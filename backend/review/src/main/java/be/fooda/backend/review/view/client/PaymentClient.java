package be.fooda.backend.review.view.client;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class PaymentClient {

    private final RestTemplate restClient;

}
