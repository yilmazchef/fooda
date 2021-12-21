package be.fooda.backend.product.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
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
        this.priceId = priceId;
        return this;
    }

    public PriceResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    public PriceResponse withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public PriceResponse withExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    public PriceResponse withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    public PriceResponse withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceResponse)) return false;
        PriceResponse that = (PriceResponse) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getCurrency(), that.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCurrency());
    }
}
