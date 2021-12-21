package be.fooda.frontend.customer.data.dto.basket;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    Long id;
    String title;
    Long productId;
    Double quantity;
    BigDecimal price;
    BigDecimal discount;
    MediaResponse media;

    public ProductResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductResponse withProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public ProductResponse withQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductResponse withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductResponse withDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public ProductResponse withMedia(MediaResponse media) {
        this.media = media;
        return this;
    }

    public ProductResponse withTitle(String title) {
        this.title = title;
        return this;
    }
}
