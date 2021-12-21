package be.fooda.backend.basket.view.client;

import be.fooda.backend.basket.model.remote.ProductClientPriceResponse;
import be.fooda.backend.basket.model.remote.ProductClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(status.equals(HttpStatus.NOT_FOUND)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found");
        }

        if(!response.hasBody()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The response does NOT contain a body!");
        }

        ProductClientResponse product = response.getBody();

        if(Objects.isNull(product.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The price does NOT contain an value.");
        }
        return product.getId();

    }

    // PRODUCTION_URL : https://www.fooda.be/api/v1/products
    public BigDecimal getDefaultPrice(Long productId) {

        HttpEntity emptyEntity = HttpEntity.EMPTY;

        Map<String, Long> requestParams = new HashMap<>();

        requestParams.put("productId", productId);

        ResponseEntity<ProductClientPriceResponse> response = restClient.exchange(PRODUCT_API_URL + "/get/one", HttpMethod.GET, emptyEntity, ProductClientPriceResponse.class, requestParams);

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

        ProductClientPriceResponse price = response.getBody();

       /* if(Objects.isNull(price.getAmount())){
            throw new ResourceNotFoundException("The price does NOT contain an value.");
        }
        return price.getAmount();*/

        return null;
    }
}


