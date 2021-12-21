package be.fooda.backend.basket.model.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateBasketRequest {

    String session;

    CreateCustomerRequest customer;

    CreateStoreRequest store;

    Set<CreateProductRequest> products = new LinkedHashSet<>();
}
