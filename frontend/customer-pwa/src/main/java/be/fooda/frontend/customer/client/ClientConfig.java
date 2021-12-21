package be.fooda.frontend.customer.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {
    
    @Bean
    public RestTemplate getRestTemplateBean() {
        return new RestTemplate();
    }
}
