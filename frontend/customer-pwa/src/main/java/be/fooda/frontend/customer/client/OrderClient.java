package be.fooda.frontend.customer.client;

import be.fooda.frontend.customer.data.dto.order.CreateOrderRequest;
import be.fooda.frontend.customer.data.dto.order.OrderResponse;
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
public class OrderClient {

    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;
    private final String baseUrl = "http://localhost:8101/api/v2/order/";

    public ResponseEntity<OrderResponse> create(CreateOrderRequest order) {

        final var url = baseUrl.concat("create/one");
        final var circuit = circuitBreakerFactory.create("CircuitBreakerOrderCreate");
        final var params = new LinkedHashMap<String, Object>();
        final var entity = new HttpEntity<>(order);
        final var responseType = OrderResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.POST, entity, responseType, params),
                throwable -> createFallBack());

    }

    public ResponseEntity<OrderResponse> findById(Long orderId) {

        final var url = baseUrl.concat("get/one");
        final var circuit = circuitBreakerFactory.create("CircuitBreakerOrderFindById");
        final var params = new LinkedHashMap<String, Object>();
        params.put("orderId", orderId);
        final var responseType = OrderResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findSingleFallBack());
    }

    public ResponseEntity<List<OrderResponse>> findAll(final int pageNo, final int pageSize) {

        final var url = baseUrl.concat("get/all");
        final var circuit = circuitBreakerFactory.create("CircuitBreakerOrderFindAll");
        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        final var responseType = new ParameterizedTypeReference<List<OrderResponse>>() {
        };

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());
    }

    public ResponseEntity<List<OrderResponse>> search(final String keyword, final int pageNo, final int pageSize) {

        final var url = baseUrl + "search/" + keyword;
        final var circuit = circuitBreakerFactory.create("CircuitBreakerOrderSearch");
        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        final var responseType = new ParameterizedTypeReference<List<OrderResponse>>() {
        };

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());
    }

    public ResponseEntity<List<OrderResponse>> findManyFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<OrderResponse> findSingleFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<OrderResponse> createFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<OrderResponse> updateFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<OrderResponse> deleteFallBack() {
        return ResponseEntity.badRequest().build();
    }


}
