package be.fooda.frontend.customer.client;

import be.fooda.frontend.customer.data.dto.basket.BasketResponse;
import be.fooda.frontend.customer.data.dto.basket.CreateBasketRequest;
import be.fooda.frontend.customer.data.dto.basket.HttpEndpoints;
import be.fooda.frontend.customer.data.dto.basket.UpdateBasketRequest;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.fusion.Endpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@Endpoint
@AnonymousAllowed
@RequiredArgsConstructor
public class BasketClient {

    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;
    private final String baseUrl = "http://localhost:8011/api/v2/basket/";

    public ResponseEntity<BasketResponse> updateProductQuantity(Long basketId, Long productId, Long quantity) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketUpdate");
        final var url = baseUrl + HttpEndpoints.PATCH_SINGLE_BY_ID;
        final var params = new LinkedHashMap<String, Object>();
        params.put("basketId", basketId);
        params.put("productId", productId);
        params.put("quantity", quantity);
        final var responseType = BasketResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.PUT, HttpEntity.EMPTY, responseType, params),
                throwable -> updateFallBack());
    }

    public ResponseEntity<BasketResponse> updateById(String basketId, UpdateBasketRequest request) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketUpdateById");
        final var url = baseUrl + HttpEndpoints.PUT_SINGLE_BY_ID;
        final var params = new LinkedHashMap<String, Object>();
        params.put("basketId", basketId);
        final var entity = new HttpEntity<>(request);
        final var responseType = BasketResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.PUT, entity, responseType, params),
                throwable -> updateFallBack());
    }

    public ResponseEntity<BasketResponse> updateBySession(String session, UpdateBasketRequest request) {

        final var url = baseUrl + "edit/one/by-session";

        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketUpdateBySession");

        final var params = new LinkedHashMap<String, Object>();
        params.put("session", session);

        final var entity = new HttpEntity<>(request);

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.PUT, entity, BasketResponse.class, params),
                throwable -> updateFallBack());
    }

    public ResponseEntity<List<BasketResponse>> findAll(final int pageNo, final int pageSize) {

        final var url = baseUrl + "get/all";
        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketFindAll");
        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        final var responseType = new ParameterizedTypeReference<List<BasketResponse>>() {
        };

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());
    }

    public ResponseEntity<List<BasketResponse>> findBySession(String session) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketFindBySession");
        final var params = new LinkedHashMap<String, Object>();
        params.put("session", session);
        final var responseType = new ParameterizedTypeReference<List<BasketResponse>>() {
        };

        return circuit.run(
                () -> restTemplate.exchange(
                        "http://localhost:8011/api/v2/basket/get/all/by-session", HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());
    }

    public ResponseEntity<BasketResponse> findById(Long basketId) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketFindById");
        final var params = new LinkedHashMap<String, Object>();
        params.put("basketId", basketId);

        return circuit.run(
                () -> restTemplate.exchange(
                        "http://localhost:8011/api/v2/basket/get/one", HttpMethod.GET, HttpEntity.EMPTY, BasketResponse.class, params),
                throwable -> findSingleFallBack());
    }

    public ResponseEntity<BasketResponse> create(CreateBasketRequest product) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketCreate");
        final var params = new LinkedHashMap<String, Object>();
        final var entity = new HttpEntity<>(product);
        final var responseType = BasketResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(
                        "http://localhost:8011/api/v2/basket/add/one", HttpMethod.POST, entity, responseType, params),
                throwable -> createFallBack());
    }

    public ResponseEntity<Boolean> exists(String session, Long storeId) {

        final var url = baseUrl + HttpEndpoints.GET_EXISTS_BY_UNIQUE_FIELDS;
        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketExists");
        final var params = new LinkedHashMap<String, Object>();
        params.put("session", session);
        params.put("storeId", storeId);
        final var responseType = Boolean.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> existsFallBack());
    }

    public ResponseEntity<BasketResponse> delete(String basketId) {

        final var url = baseUrl + "delete/one";
        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketDelete");
        final var params = new LinkedHashMap<String, Object>();
        params.put("basketId", basketId);
        final var responseType = BasketResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, responseType, params),
                throwable -> deleteFallBack());
    }

    public ResponseEntity<BasketResponse> deletePermanently(String basketId) {

        final var url = baseUrl + "delete/one/permanent";
        final var circuit = circuitBreakerFactory.create("CircuitBreakerBasketDeletePermanently");
        final var params = new LinkedHashMap<String, Object>();
        params.put("basketId", basketId);
        final var responseType = BasketResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, responseType, params),
                throwable -> deleteFallBack());
    }

    public ResponseEntity<List<BasketResponse>> findManyFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<BasketResponse> findSingleFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<BasketResponse> createFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<BasketResponse> updateFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<BasketResponse> deleteFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<Boolean> existsFallBack() {
        return ResponseEntity.notFound().build();
    }
}
