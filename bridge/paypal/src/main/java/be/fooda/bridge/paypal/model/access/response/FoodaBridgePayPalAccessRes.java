package be.fooda.bridge.paypal.model.access.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodaBridgePayPalAccessRes {

    private String scope;

    private String accessToken;

    private String tokenType;

    private String appId;

    private Integer expiresIn;

    private String nonce;

}
