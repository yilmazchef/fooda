package be.fooda.frontend.customer.client;

import be.fooda.frontend.customer.data.dto.delivery.CreateDeliveryRequest;
import be.fooda.frontend.customer.data.dto.delivery.DeliveryResponse;
import be.fooda.frontend.customer.data.dto.delivery.UpdateDeliveryRequest;
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
public class DeliveryClient {

    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;
    private final String baseUrl = "http://localhost:8051/api/v2/delivery/";

    public ResponseEntity<DeliveryResponse> create(CreateDeliveryRequest delivery) {

        final var url = baseUrl.concat("add/one");
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliveryCreateSingle");
        final var params = new LinkedHashMap<String, Object>();
        final var entity = new HttpEntity<>(delivery);
        final var responseType = DeliveryResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.POST, entity, responseType, params),
                throwable -> createFallBack());
    }

    public ResponseEntity<DeliveryResponse> update(Long deliveryId, UpdateDeliveryRequest delivery) {

        final var url = baseUrl + "edit/one/" + deliveryId;
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliveryUpdateById");
        final var params = new LinkedHashMap<String, Object>();
        params.put("deliveryId", deliveryId);
        final var responseType = DeliveryResponse.class;
        final var entity = new HttpEntity<>(delivery);

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.PUT, entity, responseType, params),
                throwable -> updateFallBack());
    }

    public ResponseEntity<DeliveryResponse> delete(Long deliveryId) {

        final var url = baseUrl + "delete/one/" + deliveryId;
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliveryDeleteById");
        final var params = new LinkedHashMap<String, Object>();
        final var responseType = DeliveryResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, responseType, params),
                throwable -> deleteFallBack());
    }

    public ResponseEntity<DeliveryResponse> deletePermanently(Long deliveryId) {

        final var url = baseUrl + "delete/one/permanent/" + deliveryId;
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliveryDeletePermanentlyById");
        final var params = new LinkedHashMap<String, Object>();
        final var responseType = DeliveryResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, responseType, params),
                throwable -> deleteFallBack());

    }

    public ResponseEntity<DeliveryResponse> findById(Long deliveryId) {

        final var url = baseUrl + "get/one" + deliveryId;
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliveryFindById");
        final var params = new LinkedHashMap<String, Object>();
        params.put("deliveryId", deliveryId);
        final var responseType = DeliveryResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findSingleFallBack());
    }

    public ResponseEntity<DeliveryResponse> findByOrderAndStore(Long orderId, Long storeId) {

        final var url = baseUrl + "exists/unique";
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliveryFindByOrderAndStore");
        final var params = new LinkedHashMap<String, Object>();
        params.put("orderId", orderId);
        params.put("storeId", storeId);
        final var responseType = DeliveryResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findSingleFallBack());
    }

    public ResponseEntity<List<DeliveryResponse>> findAll(final int pageNo, final int pageSize) {

        final var url = baseUrl + "get/all";
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliveryFindAll");
        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        final var responseType = new ParameterizedTypeReference<List<DeliveryResponse>>() {
        };

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());
    }

    public ResponseEntity<List<DeliveryResponse>> search(String keyword) {

        final var url = baseUrl + "search";
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliverySearch");
        final var params = new LinkedHashMap<String, Object>();
        params.put("keyword", keyword);
        final var responseType = new ParameterizedTypeReference<List<DeliveryResponse>>() {
        };

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());

    }

    public ResponseEntity<Boolean> existsByUniqueFields(Long orderId, Long storeId) {

        final var url = baseUrl + "exists/unique";
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliveryExistsByUniqueFields");
        final var params = new LinkedHashMap<String, Object>();
        params.put("orderId", orderId);
        params.put("storeId", storeId);
        final var responseType = Boolean.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> existsSingleFallBack());
    }

    public ResponseEntity<Boolean> existById(Long deliveryId) {

        final var url = baseUrl + "exists/one" + deliveryId;
        final var circuit = circuitBreakerFactory.create("CircuitBreakerDeliveryExistsById");
        final var params = new LinkedHashMap<String, Object>();
        params.put("deliveryId", deliveryId);
        final var responseType = Boolean.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> existsSingleFallBack());
    }

    public ResponseEntity<List<DeliveryResponse>> findManyFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<DeliveryResponse> findSingleFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Boolean> existsSingleFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<DeliveryResponse> createFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<DeliveryResponse> updateFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<DeliveryResponse> deleteFallBack() {
        return ResponseEntity.badRequest().build();
    }
}
