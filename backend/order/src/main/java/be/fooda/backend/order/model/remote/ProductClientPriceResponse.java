package be.fooda.backend.order.model.remote;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"priceId"})
public class ProductClientPriceResponse {
    Long productId;
    Long priceId;
    BigDecimal amount;
    BigDecimal tax;
    String title;
}
