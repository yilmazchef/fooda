package be.fooda.backend.media;

import be.fooda.backend.media.model.entity.MediaEntity;
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

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Media API", version = "2.0", description = "Media Information"))
public class MediaApp implements CommandLineRunner {

    // MAIN_APP_RUNNER
    public static void main(String[] args) {
        SpringApplication.run(MediaApp.class, args);
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
        /*
        final var searchSession = Search.session(entityManager);
        final var indexer = searchSession.massIndexer(MediaEntity.class);
        indexer.startAndWait();
        */
    }

}
