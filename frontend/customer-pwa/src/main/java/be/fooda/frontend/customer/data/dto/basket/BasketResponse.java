package be.fooda.frontend.customer.data.dto.basket;


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

    Long id;
    String session;
    CustomerResponse customer;
    StoreResponse store;
    Set<ProductResponse> products = new LinkedHashSet<>();
    BigDecimal totalPrice;

    public BasketResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public BasketResponse withSession(String session) {
        this.session = session;
        return this;
    }

    public BasketResponse withCustomer(CustomerResponse customer) {
        this.customer = customer;
        return this;
    }

    public BasketResponse withStore(StoreResponse store) {
        this.store = store;
        return this;
    }

    public BasketResponse withProducts(Set<ProductResponse> products) {
        this.products = products;
        return this;
    }

    public BasketResponse withNewProducts() {
        this.products = new LinkedHashSet<>();
        return this;
    }

    public BasketResponse withTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
