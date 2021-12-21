package be.fooda.bridge.paypal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodaBridgePaypalApp {

    public static void main(String[] args) {
        SpringApplication.run(FoodaBridgePaypalApp.class, args);
    }

}
