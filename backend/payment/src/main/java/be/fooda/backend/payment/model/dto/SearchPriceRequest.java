package be.fooda.backend.payment.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPriceRequest {

    String title;
    BigDecimal amount;
    LocalDateTime expiresAt;
    Boolean isDefault;
    String currency; // EURO, €, EUR -> EUR

    public SearchPriceRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public SearchPriceRequest withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public SearchPriceRequest withExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    public SearchPriceRequest withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    public SearchPriceRequest withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchPriceRequest)) return false;
        SearchPriceRequest that = (SearchPriceRequest) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getCurrency(), that.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCurrency());
    }
}
