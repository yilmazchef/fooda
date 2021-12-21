package be.fooda.backend.ranking.view.client;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class CustomerClient {

    private final RestTemplate restClient;

}
