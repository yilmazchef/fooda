package be.fooda.backend.basket.model.remote;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"priceId"})
public class ProductClientResponse {

    Long id;

}
