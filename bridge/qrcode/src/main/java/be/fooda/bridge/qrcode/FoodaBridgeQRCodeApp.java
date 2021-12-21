package be.fooda.bridge.qrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodaBridgeQRCodeApp {

    public static void main(String[] args) {
        SpringApplication.run(FoodaBridgeQRCodeApp.class, args);
    }

}
