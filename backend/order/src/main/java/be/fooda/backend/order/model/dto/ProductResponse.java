package be.fooda.backend.order.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.math.BigDecimal;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"productId"})
// TODO Do I need this response object?
public class ProductResponse implements Serializable {

    Long productId;
    Integer quantity;
    String productName;
    BigDecimal price;
    BigDecimal tax;
}