package be.fooda.backend.basket.model.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasketResponse {

    String id;
    String session;
    CustomerResponse customer;
    StoreResponse store;
    Set<ProductResponse> products = new LinkedHashSet<>();
    BigDecimal totalPrice;
}
