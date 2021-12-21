package be.fooda.frontend.customer.data.dto.basket;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateBasketRequest {

    Set<UpdateProductRequest> products = new LinkedHashSet<>();
    Set<UpdatePaymentRequest> payments = new LinkedHashSet<>();

    public UpdateBasketRequest withProducts(Set<UpdateProductRequest> products) {
        this.products = products;
        return this;
    }

    public UpdateBasketRequest withPayments(Set<UpdatePaymentRequest> payments) {
        this.payments = payments;
        return this;
    }
}
