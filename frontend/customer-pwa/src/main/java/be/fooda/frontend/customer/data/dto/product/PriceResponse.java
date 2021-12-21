package be.fooda.frontend.customer.data.dto.product;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "priceId" })

// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)

public class PriceResponse implements Serializable{

    Long priceId;
    String title;
    BigDecimal amount;
    LocalDateTime expiresAt;
    Boolean isDefault;
    String currency; // EURO, €, EUR -> EUR


    public PriceResponse withPriceId(Long priceId) {
        setPriceId(priceId);
        return this;
    }

    public PriceResponse withTitle(String title) {
        setTitle(title);
        return this;
    }

    public PriceResponse withAmount(BigDecimal amount) {
        setAmount(amount);
        return this;
    }

    public PriceResponse withExpiresAt(LocalDateTime expiresAt) {
        setExpiresAt(expiresAt);
        return this;
    }

    public PriceResponse withIsDefault(Boolean isDefault) {
        setIsDefault(isDefault);
        return this;
    }

    public PriceResponse withCurrency(String currency) {
        setCurrency(currency);
        return this;
    }

}
