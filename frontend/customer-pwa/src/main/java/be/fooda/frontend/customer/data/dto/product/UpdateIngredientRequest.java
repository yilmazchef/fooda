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
@EqualsAndHashCode(of = { "title" })

// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)

public class UpdateIngredientRequest implements Serializable{

    String title;
    BigDecimal price;
}
