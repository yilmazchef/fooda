package be.fooda.bridge.paypal.service.impl;

import be.fooda.bridge.paypal.model.access.request.FoodaBridgePayPalAccessReq;
import be.fooda.bridge.paypal.model.access.response.FoodaBridgePayPalAccessRes;
import be.fooda.bridge.paypal.service.FoodaBridgePayPalAccessService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FoodaBridgePayPalAccessServiceImpl implements FoodaBridgePayPalAccessService<FoodaBridgePayPalAccessReq, FoodaBridgePayPalAccessRes> {

    @Autowired
    private OkHttpClient client;

    @Autowired
    private ObjectMapper mapper;

    @Value("${paypal.client.id}")
    private String cid;

    @Value("${paypal.client.secret}")
    private String cs;

    @Value("${paypal.client.sandbox.url}")
    private String url;


    @SneakyThrows
    @Override
    public FoodaBridgePayPalAccessRes generateToken() {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials");
        Request request = new Request.Builder()
                .url(url + "/v1/oauth2/token")
                .method("POST", body)
                .addHeader("Authorization", Credentials.basic(cid, cs))
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();
        return mapper.readValue(response.body().string(), FoodaBridgePayPalAccessRes.class);
    }
}
