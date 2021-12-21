package be.fooda.cloud.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConverterApp {

    public static void main(String[] args) {
        SpringApplication.run(ConverterApp.class, args);
    }
}
