package be.fooda.frontend.customer.data.dto.product;


import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "ingredientId" })

// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)

public class IngredientResponse implements Serializable{

    Long ingredientId;
    String title;
    BigDecimal price;

    public IngredientResponse withIngredientId(Long ingredientId) {
        setIngredientId(ingredientId);
        return this;
    }

    public IngredientResponse withTitle(String title) {
        setTitle(title);
        return this;
    }

    public IngredientResponse withPrice(BigDecimal price) {
        setPrice(price);
        return this;
    }


}
