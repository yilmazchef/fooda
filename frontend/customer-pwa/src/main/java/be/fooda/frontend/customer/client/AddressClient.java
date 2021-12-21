package be.fooda.frontend.customer.client;

import be.fooda.frontend.customer.data.dto.address.AddressResponse;
import be.fooda.frontend.customer.data.dto.address.CreateAddressRequest;
import be.fooda.frontend.customer.data.dto.address.HttpEndpoints;
import be.fooda.frontend.customer.data.dto.address.UpdateAddressRequest;
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
public class AddressClient {

    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;
    private final String baseUrl = "http://localhost:8080/api/v2/address/";

    public ResponseEntity<AddressResponse> create(CreateAddressRequest address) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerAddressCreate");
        final var url = baseUrl.concat(HttpEndpoints.ADDRESSS_POST_SINGLE_TEXT);
        final var params = new LinkedHashMap<String, Object>();
        final var entity = new HttpEntity<>(address);
        final var responseType = AddressResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.POST, entity, responseType, params),
                throwable -> createFallBack());
    }

    public ResponseEntity<AddressResponse> update(Long addressId, UpdateAddressRequest address) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerAddressUpdate");
        final var url = baseUrl
                .concat(HttpEndpoints.ADDRESSS_PUT_SINGLE_TEXT.replace("{addressId}", String.valueOf(addressId)));
        final var params = new LinkedHashMap<String, Object>();
        final var entity = new HttpEntity<>(address);
        final var responseType = AddressResponse.class;

        return circuit.run(
                () ->  restTemplate.exchange(url, HttpMethod.PUT, entity, responseType, params),
                throwable -> updateFallBack());
    }

    public ResponseEntity<AddressResponse> findById(Long addressId) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerAddressFindById");
        final var url = baseUrl
                .concat(HttpEndpoints.ADDRESSS_FIND_BY_ID_TEXT).replace("{addressId}", String.valueOf(addressId));
        final var params = new LinkedHashMap<String, Object>();
        params.put("addressId", addressId);
        final var responseType = AddressResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findSingleFallBack());

    }

    public ResponseEntity<List<AddressResponse>> findByUserId(final Long userId, final Integer pageNo, final Integer pageSize) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerAddressFindByUserId");
        final var url = baseUrl
                .concat(HttpEndpoints.ADDRESSS_FIND_ALL_BY_USER_ID_TEXT.replace("{userId}", String.valueOf(userId)));
        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        final var responseType = new ParameterizedTypeReference<List<AddressResponse>>() {  };

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());
    }

    public ResponseEntity<List<AddressResponse>> search(final String keyword, final int pageNo, final int pageSize) {

        final var circuit = circuitBreakerFactory.create("CircuitBreakerAddressSearch");

        final var url = baseUrl
                .concat(HttpEndpoints.ADDRESSS_SEARCH_TEXT.replace("{keyword}", keyword));

        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        final var responseType = new ParameterizedTypeReference<List<AddressResponse>>() {};

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findManyFallBack());
    }

    public ResponseEntity<List<AddressResponse>> findManyFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<AddressResponse> findSingleFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<AddressResponse> createFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<AddressResponse> updateFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<AddressResponse> deleteFallBack() {
        return ResponseEntity.badRequest().build();
    }
}
