package be.fooda.bridge.paypal.service.impl;

import be.fooda.bridge.paypal.model.order.request.FoodaBridgePayPalOrderReq;
import be.fooda.bridge.paypal.model.order.response.FoodaBridgePayPalOrderRes;
import be.fooda.bridge.paypal.service.FoodaBridgePayPalOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FoodaBridgePayPalOrderServiceImpl implements FoodaBridgePayPalOrderService<FoodaBridgePayPalOrderReq, FoodaBridgePayPalOrderRes> {

    @Autowired
    private OkHttpClient client;

    @Autowired
    private ObjectMapper mapper;

    @Value("${paypal.client.token}")
    private String token;

    @Value("${paypal.client.sandbox.url}")
    private String url;

    @SneakyThrows
    @Override
    public FoodaBridgePayPalOrderRes getOne(String id) {
        return null;
    }

    @SneakyThrows
    @Override
    public FoodaBridgePayPalOrderRes add(FoodaBridgePayPalOrderReq req) {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, mapper.writeValueAsString(req));
        Request request = new Request.Builder()
                .url(url + "/v2/checkout/orders")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return mapper.readValue(response.body().string(), FoodaBridgePayPalOrderRes.class);
    }

    @SneakyThrows
    @Override
    public FoodaBridgePayPalOrderRes edit(String id) {
        return null;
    }

    @SneakyThrows
    @Override
    public FoodaBridgePayPalOrderRes remove(String id) {
        return null;
    }

    @SneakyThrows
    @Override
    public FoodaBridgePayPalOrderRes authorize() {
        return null;
    }

    @SneakyThrows
    @Override
    public FoodaBridgePayPalOrderRes capture() {
        return null;
    }
}
