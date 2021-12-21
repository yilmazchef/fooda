package be.fooda.bridge.twilio.service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.util.X509CertUtils;
import com.nimbusds.jwt.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;

@Slf4j
@Service
public class TokenValidator {

    @Value("${service.provider.pkcs12}")
    private String clientPKCS;

    @Value("${token.issuer.x509}")
    private String serverCertificate;

    private String user = "unknown";
    private String account = "unknown";
    private String token = "unknown";

    private RSAKey getPublicKey(String certificateFile) {
        RSAKey publicKey = null;
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(certificateFile)));
            X509Certificate certificate = X509CertUtils.parse(fileContent);
            publicKey = RSAKey.parse(certificate);
            log.info("Public key was fetched from the certificate");
        } catch (IOException | JOSEException e) {
            log.error(e.toString());
        }
        return publicKey;
    }

    private RSAKey getJSONWebKey(String pkcsFile) {
        RSAKey jwk = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream pkcs = new FileInputStream(pkcsFile);
            keyStore.load(pkcs, "".toCharArray());
            Enumeration aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                String alias = (String) aliases.nextElement();
                RSAPrivateKey privateKey = (RSAPrivateKey) keyStore.getKey(alias, "".toCharArray());
                X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
                RSAKey publicKey = RSAKey.parse(certificate);
                jwk = new RSAKey.Builder(publicKey).privateKey(privateKey).build();
                break;
            }
        } catch (IOException
                | KeyStoreException
                | JOSEException
                | NoSuchAlgorithmException
                | UnrecoverableKeyException
                | CertificateException ex) {
            log.error(ex.toString());
        }
        return jwk;
    }

    public boolean isValid(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String key = headers.nextElement();
            if (key.trim().equalsIgnoreCase("Authorization")) {
                String authorizationHeader = request.getHeader(key);
                if (!authorizationHeader.isBlank()) {
                    String[] tokenData = authorizationHeader.split(" ");
                    if (tokenData.length == 2 && tokenData[0].trim().equalsIgnoreCase("Bearer")) {
                        token = tokenData[1];
                        log.info("Received token: " + token);
                        break;
                    }
                }
            }
        }

        try {
            JWT jwt = JWTParser.parse(token);
            if (jwt instanceof EncryptedJWT) {
                EncryptedJWT jwe = (EncryptedJWT) jwt;
                RSAKey clientJWK = getJSONWebKey(clientPKCS);
                JWEDecrypter decrypter = new RSADecrypter(clientJWK);
                jwe.decrypt(decrypter);
                SignedJWT jws = jwe.getPayload().toSignedJWT();

                RSAKey serverJWK = getPublicKey(serverCertificate);
                RSASSAVerifier signVerifier = new RSASSAVerifier(serverJWK);
                if (jws.verify(signVerifier)) {
                    JWTClaimsSet claims = jws.getJWTClaimsSet();
                    Date expiryTime = claims.getExpirationTime();
                    log.info("Expiry time = " + expiryTime.toString());
                    if (expiryTime.after(new Date())) {
                        user = claims.getStringClaim("user");
                        account = claims.getStringClaim("account");
                        log.info("Token validated for user = " + user + ", account = " + account);
                        return true;
                    }
                }
            }
        } catch (ParseException | JOSEException ex) {
            log.error(ex.toString());
        }
        return false;
    }

    public String getUser() {
        return user;
    }

    public String getAccount() {
        return account;
    }

    public String getToken() {
        return token;
    }
}
