package be.fooda.backend.ranking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Ranking API", version = "1.1", description = "Ranking Information"))
public class RankingApp {
    public static void main(String[] args) {
        SpringApplication.run(RankingApp.class, args);
    }

    @Bean
    public RestTemplate restTemplateConfig() {
        return new RestTemplate();
    }
}
