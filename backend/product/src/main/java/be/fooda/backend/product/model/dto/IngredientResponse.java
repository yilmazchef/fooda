package be.fooda.backend.product.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

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
public class IngredientResponse implements Serializable{

    Long ingredientId;
    String title;
    BigDecimal price;

    public IngredientResponse withIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
        return this;
    }

    public IngredientResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    public IngredientResponse withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientResponse)) return false;
        IngredientResponse that = (IngredientResponse) o;
        return Objects.equals(getIngredientId(), that.getIngredientId()) && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredientId(), getTitle());
    }
}
