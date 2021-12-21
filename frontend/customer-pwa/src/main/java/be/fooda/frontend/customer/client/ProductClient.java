package be.fooda.frontend.customer.client;

import be.fooda.frontend.customer.data.dto.product.CreateProductRequest;
import be.fooda.frontend.customer.data.dto.product.HttpEndpoints;
import be.fooda.frontend.customer.data.dto.product.ProductResponse;
import be.fooda.frontend.customer.data.dto.product.UpdateProductRequest;
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
public class ProductClient {

    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;
    private final String baseUrl = "http://localhost:8121/api/v2/product/";

    public ResponseEntity<ProductResponse> create(CreateProductRequest product) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerProductCreateSingle");
        final var params = new LinkedHashMap<String, Object>();
        final var entity = new HttpEntity<>(product);
        final var responseType = ProductResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(baseUrl + HttpEndpoints.PRODUCTS_POST_SINGLE_TEXT, HttpMethod.POST, entity, responseType, params),
                throwable -> createFallBack());
    }

    public ResponseEntity<ProductResponse> update(Long productId, UpdateProductRequest product) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerProductUpdateById");
        final var params = new LinkedHashMap<String, Object>();
        final var entity = new HttpEntity<>(product);
        final var responseType = ProductResponse.class;

        return circuit.run(
                () ->  restTemplate.exchange(baseUrl
                        .concat(HttpEndpoints.PRODUCTS_PUT_SINGLE_TEXT)
                        .replace("{productId}", String.valueOf(productId)), HttpMethod.PUT, entity, responseType, params),
                throwable -> updateFallBack());
    }

    public ResponseEntity<ProductResponse> findById(Long productId) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerProductFindById");
        final var params = new LinkedHashMap<String, Object>();
        params.put("productId", productId);
        final var responseType = ProductResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(
                        "http://localhost:8121/api/v2/products/find/one/" + productId, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findSingleFallBack());

    }

    public ResponseEntity<List<ProductResponse>> findAll(final int pageNo, final int pageSize) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerProductFindAll");
        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        final var responseType = new ParameterizedTypeReference<List<ProductResponse>>(){};

        return circuit.run(
                () -> restTemplate.exchange("http://localhost:8121/api/v2/products/find/all/", HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());
    }

    public ResponseEntity<List<ProductResponse>> search(final String keyword, final int pageNo, final int pageSize) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerProductSearch");
        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        final var responseType = new ParameterizedTypeReference<List<ProductResponse>>(){};

        return circuit.run(
                () -> restTemplate.exchange(("http://localhost:8121/api/v2/products/search/" + keyword), HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());
    }

    public ResponseEntity<List<ProductResponse>> findManyFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ProductResponse> findSingleFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ProductResponse> createFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<ProductResponse> updateFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<ProductResponse> deleteFallBack() {
        return ResponseEntity.badRequest().build();
    }

}
