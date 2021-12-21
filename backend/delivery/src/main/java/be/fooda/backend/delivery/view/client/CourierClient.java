package be.fooda.backend.delivery.view.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class CourierClient {

    private final RestTemplate restTemplate;
    private static final String url = "http://localhost:8083/api/v1/courier/";

    public boolean exist(Long courierId) {
        return true;
    }

    public boolean getCourier(Long courierId) {
        return true;
    }


}
