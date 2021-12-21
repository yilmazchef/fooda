package be.fooda.backend.ranking.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductRequest {

    Long productId;
    Integer ranking;
    String session;
    Double quantity;
    BigDecimal price;
    BigDecimal discount;
    String imageUrl;
}
