package be.fooda.backend.user.bridge;

import be.fooda.backend.user.model.twilio.request.MessageRequest;
import be.fooda.backend.user.model.twilio.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class TwilioBridge {

    private final RestTemplate restTemplate;

    @Value("${twilio.bridge.url}")
    private String baseURL;

    public void sendCode(String phone, String code, String password) {

        MessageRequest request = new MessageRequest();

        request.setMessage("Fooda validation code: " + code + " \n After validation is successful, you can this password to login: " + password);
        request.setNumbers(Collections.singletonList(phone));

        ResponseEntity<MessageResponse> twilioResponse = restTemplate.postForEntity(baseURL + "/sms/send", request, MessageResponse.class);

        if (!twilioResponse.getStatusCode().is2xxSuccessful()) {
            log.trace("Sms validation code could not be sent user phone " + phone);
        } else {
            log.trace("Sms validation code is sent to user phone " + phone);
        }
    }

    public void sendValidated(String phone) {

        MessageRequest request = new MessageRequest();

        request.setMessage("Fooda user is validated. You can now use your password to login anytime.");
        request.setNumbers(Collections.singletonList(phone));

        ResponseEntity<MessageResponse> twilioResponse = restTemplate.postForEntity(baseURL + "/sms/send", request, MessageResponse.class);

        if (!twilioResponse.getStatusCode().is2xxSuccessful()) {
            log.trace("Sms notification code could not be sent user phone " + phone);
        } else {
            log.trace("Sms notification code is sent to user phone " + phone);
        }
    }
}