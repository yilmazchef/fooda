package be.fooda.backend.delivery;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Delivery API", version = "2.1", description = "Delivery Information"))
public class DeliveryApp {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApp.class, args);
    }

    @Bean
    public RestTemplate restTemplateConfig() {
        return new RestTemplate();
    }
}
