package be.fooda.backend.basket;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Basket API", version = "2.0", description = "Basket Information"))
public class BasketApp {
    public static void main(String[] args) {
        SpringApplication.run(BasketApp.class, args);
    }

    @Bean
    public RestTemplate restTemplateConfig() {
        return new RestTemplate();
    }
}
