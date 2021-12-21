package be.fooda.bridge.currency.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkHttpConfig {

    @Bean
    public OkHttpClient getOkHttpClientBean() {
        return new OkHttpClient().newBuilder().build();
    }
}