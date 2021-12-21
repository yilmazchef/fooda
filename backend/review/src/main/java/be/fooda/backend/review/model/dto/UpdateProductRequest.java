package be.fooda.backend.review.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductRequest {

    Long productId;
    String review;
    String session;
    Double quantity;
    BigDecimal price;
    BigDecimal discount;
    String imageUrl;
}
