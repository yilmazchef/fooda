package be.fooda.frontend.customer.data.generator;

import be.fooda.frontend.customer.data.Role;
import be.fooda.frontend.customer.data.entity.User;
import be.fooda.frontend.customer.data.service.UserRepository;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        return args -> {

            Logger logger = LoggerFactory.getLogger(getClass());
            if (userRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 2 User entities...");

            // User ID -> 1
            final var john = new User();
            john.setName("John Doe");
            john.setUsername("john@doe.be");
            john.setHashedPassword(passwordEncoder.encode("john"));
            john.setProfilePictureUrl(
                    "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
            john.setRoles(Collections.singleton(Role.USER));
            userRepository.save(john);

            // User ID -> 2
            final var bella = new User();
            bella.setName("Bella Bruening");
            bella.setUsername("bella@bruening.be");
            bella.setHashedPassword(passwordEncoder.encode("bella"));
            bella.setProfilePictureUrl(
                    "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
            bella.setRoles(Collections.singleton(Role.USER));
            userRepository.save(bella);

            // User ID -> 3
            final var rosa = new User();
            rosa.setName("Rosa Plants");
            rosa.setUsername("rosa@plants.be");
            rosa.setHashedPassword(passwordEncoder.encode("rosa"));
            rosa.setProfilePictureUrl(
                    "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
            rosa.setRoles(Collections.singleton(Role.USER));
            userRepository.save(rosa);

            // User ID -> 4
            final var earlie = new User();
            earlie.setName("Earlie Wheaton");
            earlie.setUsername("earlie@wheaton.be");
            earlie.setHashedPassword(passwordEncoder.encode("earlie"));
            earlie.setProfilePictureUrl(
                    "https://images.unsplash.com/photo-1607746882042-944635dfe10e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
            earlie.setRoles(Collections.singleton(Role.ADMIN));
            userRepository.save(earlie);

            // User ID -> 5
            final var vincent = new User();
            vincent.setName("Vincent Hayford");
            vincent.setUsername("vincent@hayford.be");
            vincent.setHashedPassword(passwordEncoder.encode("vincent"));
            vincent.setProfilePictureUrl(
                    "https://images.unsplash.com/photo-1607746882042-944635dfe10e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
            vincent.setRoles(Collections.singleton(Role.ADMIN));
            userRepository.save(vincent);

            logger.info("Generated demo data");
        };
    }

}