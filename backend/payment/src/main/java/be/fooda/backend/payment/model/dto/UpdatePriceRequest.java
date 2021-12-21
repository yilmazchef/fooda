package be.fooda.backend.payment.model.dto;

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
public class UpdatePriceRequest implements Serializable{

    String title;
    BigDecimal amount;
    LocalDateTime expiresAt;
    Boolean isDefault;
    String currency;

    public UpdatePriceRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public UpdatePriceRequest withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public UpdatePriceRequest withExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    public UpdatePriceRequest withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    public UpdatePriceRequest withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdatePriceRequest)) return false;
        UpdatePriceRequest that = (UpdatePriceRequest) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getCurrency(), that.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCurrency());
    }
}
