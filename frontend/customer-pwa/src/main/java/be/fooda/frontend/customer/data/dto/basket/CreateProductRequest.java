package be.fooda.frontend.customer.data.dto.basket;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;


@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductRequest {

    Long productId;
    String title;
    Double quantity;
    BigDecimal price;
    BigDecimal discount;
    CreateMediaRequest media;


    public CreateProductRequest withProductId(Long productId) {
        setProductId(productId);
        return this;
    }

    public CreateProductRequest withQuantity(Double quantity) {
        setQuantity(quantity);
        return this;
    }

    public CreateProductRequest withPrice(BigDecimal price) {
        setPrice(price);
        return this;
    }

    public CreateProductRequest withDiscount(BigDecimal discount) {
        setDiscount(discount);
        return this;
    }

    public CreateProductRequest withMedia(CreateMediaRequest media) {
        this.media = media;
        return this;
    }
}
