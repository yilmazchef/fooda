package be.fooda.frontend.customer.client;

import be.fooda.frontend.customer.data.dto.customer.CreateCustomerRequest;
import be.fooda.frontend.customer.data.dto.customer.CustomerResponse;
import be.fooda.frontend.customer.data.dto.customer.HttpEndpoints;
import be.fooda.frontend.customer.data.dto.customer.UpdateCustomerRequest;
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
public class CustomerClient {

    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;
    private final String baseUrl = "http://localhost:8041/api/v2/customer/";

    public ResponseEntity<List<CustomerResponse>> findAll(final int pageNo, final int pageSize) {

        final var url = baseUrl.concat(HttpEndpoints.GET_ALL_CUSTOMER);
        final var circuit = circuitBreakerFactory.create("CircuitBreakerCustomerFindAll");
        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        final var responseType = new ParameterizedTypeReference<List<CustomerResponse>>(){};

        final var response = restTemplate.exchange(url, HttpMethod.GET,
                HttpEntity.EMPTY, responseType, params);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<CustomerResponse>> findAllByUserId(Long userId) {

        final var params = new LinkedHashMap<String, Object>();
        final var circuit = circuitBreakerFactory.create("CircuitBreakerCustomerFindAllByUserId");
        final var response = restTemplate.exchange(
                "http://localhost:8041/api/v2/customers/find/user/" + userId,
                HttpMethod.GET, HttpEntity.EMPTY, CustomerResponse[].class, params);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<CustomerResponse> findById(Long customerId) {

        final var url = baseUrl
                .concat(HttpEndpoints.GET_BY_ID).replace("{customerId}", String.valueOf(customerId));

        final var params = new LinkedHashMap<String, Object>();

        final var response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, CustomerResponse.class, params);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<CustomerResponse> create(CreateCustomerRequest customer) {

        final var params = new LinkedHashMap<String, Object>();

        final var entity = new HttpEntity<>(customer);

        final var response = restTemplate.exchange(
                "http://localhost:8041/api/v2/customers/create/one",
                HttpMethod.POST, entity, CustomerResponse.class, params);


        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<CustomerResponse> update(Long customerId, UpdateCustomerRequest customer) {

        final var url = baseUrl
                .concat(HttpEndpoints.UPDATE_BY_ID.replace("{customerId}", String.valueOf(customerId)));

        final var params = new LinkedHashMap<String, Object>();

        final var entity = new HttpEntity<>(customer);

        final var response = restTemplate.exchange(url, HttpMethod.PUT, entity, CustomerResponse.class, params);

        return ResponseEntity.noContent().build();

    }

    public ResponseEntity<List<CustomerResponse>> search(final String keyword, final int pageNo, final int pageSize) {

        final var url = baseUrl
                + HttpEndpoints.CUSTOMER_SEARCH_TEXT.replace("{keyword}", keyword);

        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);

        final var response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, CustomerResponse[].class, params);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<CustomerResponse>> findManyFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<CustomerResponse> findSingleFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<CustomerResponse> createFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<CustomerResponse> updateFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<CustomerResponse> deleteFallBack() {
        return ResponseEntity.badRequest().build();
    }

}
