package be.fooda.backend.delivery.view.client;

import be.fooda.backend.delivery.model.remote.CustomerClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class CustomerClient {

    private final RestTemplate restTemplate;
    private static final String baseUrl = "http://localhost:8041/api/v2/customers/";

    public boolean exist(Long externalCourierId) {
        return true;
    }

    public boolean existsById(final Long customerId) {

        // QUERY_PARAMETERS
        final var params = new LinkedHashMap<String, Object>();
        params.put("customerId", customerId);

        final var url = baseUrl + "exists/one/" + customerId;

        // READ_RESPONSE_VIA_HTTP_REQUEST
        final var response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Boolean.class, params);

        // RETURN STORE_EXISTS_BY_ID
        return response.getStatusCode() == HttpStatus.FOUND && response.hasBody() && Objects.equals(response.getBody(), Boolean.TRUE);
    }

    public CustomerClientResponse getById(final Long customerId) {

        // QUERY_PARAMETERS
        final var params = new LinkedHashMap<String, Object>();
        params.put("customerId", customerId);

        final var url = baseUrl + "find/one/" + customerId;

        // READ_RESPONSE_VIA_HTTP_REQUEST
        final var response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, CustomerClientResponse.class, params);

        // RETURN CUSTOMER_FIND_BY_ID
        return response.getBody();
    }
}
