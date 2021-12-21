package be.fooda.bridge.currency.service.impl;

import be.fooda.bridge.currency.model.response.FoodaBridgeCurrencyRes;
import be.fooda.bridge.currency.service.FoodaBridgeCurrencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodaBridgeCurrencyServiceImpl implements FoodaBridgeCurrencyService<FoodaBridgeCurrencyRes> {

    @Autowired
    private OkHttpClient client;

    @Autowired
    private ObjectMapper mapper;

    @SneakyThrows
    @Override
    public FoodaBridgeCurrencyRes getAll(final String base) {
        Request request = new Request.Builder()
                .url("https://api.exchangeratesapi.io/latest?base=" + base)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        return mapper.readValue(response.body().string(), FoodaBridgeCurrencyRes.class);
    }

    @SneakyThrows
    @Override
    public FoodaBridgeCurrencyRes getSpecific(final String base, List<String> rateCodes) {
        final String symbols = rateCodes.stream().collect(Collectors.joining(","));
        Request request = new Request.Builder()
                .url("https://api.exchangeratesapi.io/latest?symbols=" + symbols + "&base=" + base)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        return mapper.readValue(response.body().string(), FoodaBridgeCurrencyRes.class);
    }
}
