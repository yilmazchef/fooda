package be.fooda.bridge.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodaBridgeCurrencyApp {

	public static void main(String[] args) {
		SpringApplication.run(FoodaBridgeCurrencyApp.class, args);
	}

}
