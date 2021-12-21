package be.fooda.backend.delivery.view.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class TwilioClient {

    private final RestTemplate restTemplate;

    public ResponseEntity<String> sendSmsToCustomer( String customerPhone,  String messageContent) {
        return ResponseEntity.ok(messageContent);
    }


}
