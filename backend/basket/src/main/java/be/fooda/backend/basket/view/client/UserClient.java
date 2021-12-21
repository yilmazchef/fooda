package be.fooda.backend.basket.view.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class UserClient {

    private final RestTemplate restClient;

    private static final String USER_API_URL = "http://192.168.1.31:8041/user/";


}
