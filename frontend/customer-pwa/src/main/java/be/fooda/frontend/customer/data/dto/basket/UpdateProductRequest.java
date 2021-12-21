package be.fooda.frontend.customer.data.dto.basket;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductRequest {

    Long productId;
    Double quantity;
    BigDecimal price;
    BigDecimal discount;

    public UpdateProductRequest withProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public UpdateProductRequest withQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    public UpdateProductRequest withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public UpdateProductRequest withDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }
}
