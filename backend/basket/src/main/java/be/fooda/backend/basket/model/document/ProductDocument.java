package be.fooda.backend.basket.model.document;


import be.fooda.backend.basket.model.dto.MediaResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"productId"})
@Document
public class ProductDocument {

    Long productId;
    String title;
    Double quantity;
    BigDecimal price;
    BigDecimal discount;
    MediaResponse media;

    Boolean active;
}
