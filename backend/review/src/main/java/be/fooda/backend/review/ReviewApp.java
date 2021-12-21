package be.fooda.backend.review;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Review API", version = "1.1", description = "Review Information"))
public class ReviewApp {
    public static void main(String[] args) {
        SpringApplication.run(ReviewApp.class, args);
    }

    @Bean
    public RestTemplate restTemplateConfig() {
        return new RestTemplate();
    }
}
