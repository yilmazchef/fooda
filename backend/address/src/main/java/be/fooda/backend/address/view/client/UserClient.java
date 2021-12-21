package be.fooda.backend.address.view.client;

import be.fooda.backend.address.model.extension.RestClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Objects;

// LOMBOK
@RequiredArgsConstructor
// SPRING
@RestClient
public class UserClient {

    private final RestTemplate restTemplate;

    private static final String url = "http://localhost:8083/api/v2/store/";

    // EXISTS_BY_ID
    public boolean existsById(final Long userId) {

        // QUERY_PARAMETERS
        final var params = new LinkedHashMap<String, Object>();
        params.put("userId", userId);

        // READ_RESPONSE_VIA_HTTP_REQUEST
        final var response = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Boolean.class, params);

        // RETURN STORE_EXISTS_BY_ID
        return response.getStatusCode() == HttpStatus.FOUND && response.hasBody() && Objects.equals(response.getBody(), Boolean.TRUE);
    }

}
