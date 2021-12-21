package be.fooda.backend.order;

import be.fooda.backend.order.model.entity.OrderEntity;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@OpenAPIDefinition(info = @Info(title = "Order API", version = "1.1", description = "Order Information"))
@SpringBootApplication
public class OrderApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);

    }

    // REST_CLIENT_CONFIG
    @Bean
    public RestTemplate restTemplateConfig() {
        return new RestTemplate();
    }

    // HIBERNATE_INDEXING_CONFIG
    @PersistenceContext
    EntityManager entityManager;

    // HIBERNATE_INDEXING_CONFIG
    @Override
    @Transactional(readOnly = true)
    public void run(String... args) throws Exception {
        final var searchSession = Search.session(entityManager);
        final var indexer = searchSession.massIndexer(OrderEntity.class);
        indexer.startAndWait();
    }
}
