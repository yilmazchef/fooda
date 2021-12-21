package be.fooda.backend.delivery.view.client;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class OrderClient {

    private final RestTemplate restTemplate;

    public boolean exist(Long externalOrderId) {
        return true;
    }

    public void orderDelivered() {// notify the order that the order is delivered !!!
    }
}
