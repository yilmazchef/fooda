package be.fooda.backend.basket.view.client;

import be.fooda.backend.basket.model.dto.CreateStoreRequest;
import be.fooda.backend.basket.model.remote.StoreClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class StoreClient {
    private final RestTemplate restClient;

    public boolean exists(CreateStoreRequest store) {
        return true;
    }

    public boolean exists(Long storeId) {

        HttpEntity emptyEntity = HttpEntity.EMPTY;

        Map<String, Long> requestParams = new HashMap<>();

        requestParams.put("storeId", storeId);

        ResponseEntity<StoreClientResponse> response = restClient.exchange(/*PRODUCT_API_URL +*/ "/get/one", HttpMethod.GET, emptyEntity, StoreClientResponse.class, requestParams);

        HttpStatus status = response.getStatusCode();

        if(!status.equals(HttpStatus.FOUND) && !status.equals(HttpStatus.NOT_FOUND)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(status.equals(HttpStatus.NOT_FOUND)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found");
        }

        if(!response.hasBody()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The response does NOT contain a body!");
        }

        StoreClientResponse product = response.getBody();

        if(Objects.isNull(product.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The price does NOT contain an value.");
        }
        return true;
    }
}
