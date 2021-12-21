package be.fooda.backend.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodaPaymentApp {
    public static void main(String[] args) {
        SpringApplication.run(FoodaPaymentApp.class, args);
    }
}
