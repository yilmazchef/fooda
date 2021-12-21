package be.fooda.backend.ranking.view.client;

import be.fooda.backend.ranking.model.remote.ProductClientResponse;
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


@Component
@RequiredArgsConstructor
public class ProductClient{

    private final static String PRODUCT_API_URL = "http://localhost:8081/api/v1/products";

    private final RestTemplate restClient;

    public Long existProductById(Long productId) {

        HttpEntity emptyEntity = HttpEntity.EMPTY;

        Map<String, Long> requestParams = new HashMap<>();

        requestParams.put("productId", productId);

        ResponseEntity<ProductClientResponse> response = restClient.exchange(PRODUCT_API_URL + "/get/one", HttpMethod.GET, emptyEntity, ProductClientResponse.class, requestParams);

        HttpStatus status = response.getStatusCode();

        if(!status.equals(HttpStatus.FOUND) && !status.equals(HttpStatus.NOT_FOUND)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product NOT found");
        }

        if(status.equals(HttpStatus.NOT_FOUND)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product NOT found");
        }

        if(!response.hasBody()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The response does NOT contain a body!");
        }

        ProductClientResponse product = response.getBody();

        if(Objects.isNull(product.getProductId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The price does NOT contain an value.");
        }
        return product.getProductId();

    }

}


