package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    Long id;
    Long productId;
    String name;
    CustomerResponse customer;

    public ProductResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductResponse withProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public ProductResponse withName(String name) {
        this.name = name;
        return this;
    }

    public ProductResponse withCustomer(CustomerResponse customer) {
        this.customer = customer;
        return this;
    }
}