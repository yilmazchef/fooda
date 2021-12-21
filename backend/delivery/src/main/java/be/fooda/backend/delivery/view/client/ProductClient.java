package be.fooda.backend.delivery.view.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class ProductClient {

    private final RestTemplate restTemplate;

    public boolean exist(Set<Long> externalProductIds) {
        return true;
    }

    public boolean existById(Long externalProductId, String productName) {
        return true;
    }
}
