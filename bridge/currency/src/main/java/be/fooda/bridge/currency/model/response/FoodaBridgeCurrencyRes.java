package be.fooda.bridge.currency.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodaBridgeCurrencyRes {
    private String date;
    @JsonProperty("rates")
    private FoodaBridgeCurrencyRatesRes rates;
    private String base;
}
