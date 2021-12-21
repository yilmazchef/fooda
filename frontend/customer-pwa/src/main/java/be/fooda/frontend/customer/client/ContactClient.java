package be.fooda.frontend.customer.client;

import be.fooda.frontend.customer.data.dto.contact.CreateContactRequest;
import be.fooda.frontend.customer.data.dto.customer.ContactResponse;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.fusion.Endpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Endpoint
@AnonymousAllowed
@RequiredArgsConstructor
public class ContactClient {

    private final RestTemplate rest;

    private final CircuitBreakerFactory circuitBreakerFactory;

    @Value("${CONTACT_BACKEND_URL}")
    private String baseUrl;

    public List<ContactResponse> findAll(final int pageNo, final int pageSize) {

        // http://localhost:8822/api/v1/contact/
        final var url = System.getenv("CONTACT_BACKEND_URL") + "get/all";

        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);

        final var response = rest.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ContactResponse[].class, params);

        if (response.getStatusCode() != HttpStatus.FOUND || !response.hasBody()) {
            return Collections.emptyList();
        }

        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<ContactResponse> search(final String keyword, final int pageNo, final int pageSize) {

        // http://localhost:8822/api/v1/contact/
        final var url = System.getenv("CONTACT_BACKEND_URL") + "search/" + keyword;

        final var params = new LinkedHashMap<String, Object>();
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);

        final var response = rest.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ContactResponse[].class, params);

        if (response.getStatusCode() != HttpStatus.FOUND || !response.hasBody()) {
            return Collections.emptyList();
        }

        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public Optional<ContactResponse> findById(Long contactId) {

        final var url = System.getenv("CONTACT_BACKEND_URL") + "get/one";

        final var params = new LinkedHashMap<String, Object>();
        params.put("contactId", contactId);

        final var response = rest.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, ContactResponse.class, params);

        if (response.getStatusCode() != HttpStatus.FOUND) {
            return Optional.empty();
        }

        return Optional.ofNullable(response.getBody());
    }

    public String create(CreateContactRequest contact){

        final var url = System.getenv("CONTACT_BACKEND_URL") + "add/one";

        final var params = new LinkedHashMap<String, Object>();
        
        final var entity = new HttpEntity<>(contact);

        final var response = rest.exchange(url, HttpMethod.POST, entity, String.class, params);

        if(response.getStatusCode() != HttpStatus.CREATED || !response.hasBody()){
            return "ERROR";
        }

        return response.getBody();

    }

    public ResponseEntity<List<ContactResponse>> findManyFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ContactResponse> findSingleFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ContactResponse> createFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<ContactResponse> updateFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<ContactResponse> deleteFallBack() {
        return ResponseEntity.badRequest().build();
    }

}
