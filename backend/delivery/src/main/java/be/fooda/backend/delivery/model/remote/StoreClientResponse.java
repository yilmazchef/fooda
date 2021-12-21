package be.fooda.backend.delivery.model.remote;


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
@EqualsAndHashCode(of = { "id" })

public class StoreClientResponse {

    Long productId;
    Long eTrackingId;
    String title;
    String slogan;
    String type;
    String about;
    Boolean isActive;
    Long bgImageId;
}
