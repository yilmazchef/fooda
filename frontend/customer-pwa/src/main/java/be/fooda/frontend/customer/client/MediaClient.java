package be.fooda.frontend.customer.client;

import be.fooda.frontend.customer.data.dto.media.CreateImageRequest;
import be.fooda.frontend.customer.data.dto.media.ImageResponse;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.fusion.Endpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@Endpoint
@AnonymousAllowed
@RequiredArgsConstructor
public class MediaClient {

    private final RestTemplate restTemplate;
    private final CircuitBreakerFactory circuitBreakerFactory;
    private final String baseUrl = "http://localhost:8091/api/v2/media/";

    public String getImgUrl() {
        return "https://picsum.photos/1920/1080.jpg";
    }

    public ResponseEntity<ImageResponse> create(CreateImageRequest image) {

        final var url = baseUrl.concat("add/one");
        final var circuit = circuitBreakerFactory.create("CircuitBreakerMediaCreate");
        final var params = new LinkedHashMap<String, Object>();
        final var entity = new HttpEntity<>(image);
        final var responseType = ImageResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.POST, entity, responseType, params),
                throwable -> createFallBack());
    }

    public ResponseEntity<ImageResponse> findById(Long mediaId) {

        final var url = baseUrl.concat("get/one");
        final var circuit = circuitBreakerFactory.create("CircuitBreakerMediaFindById");
        final var params = new LinkedHashMap<String, Object>();
        params.put("mediaId", mediaId);
        final var responseType = ImageResponse.class;

        return circuit.run(
                () -> restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType, params),
                throwable -> findSingleFallBack());
    }

    public ResponseEntity<List<ImageResponse>> findManyFallBack() {
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ImageResponse> findSingleFallBack() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ImageResponse()
                                .withUrl(getImgUrl())
                                .withAltText("IMAGE_NOT_FOUND")
                );
    }

    public ResponseEntity<ImageResponse> createFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<ImageResponse> updateFallBack() {
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<ImageResponse> deleteFallBack() {
        return ResponseEntity.badRequest().build();
    }
}
