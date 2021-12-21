package be.fooda.backend.payment.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class SearchIngredientRequest implements Serializable {

    String title;
    BigDecimal price;

    public SearchIngredientRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public SearchIngredientRequest withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchIngredientRequest)) return false;
        SearchIngredientRequest that = (SearchIngredientRequest) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPrice());
    }
}
