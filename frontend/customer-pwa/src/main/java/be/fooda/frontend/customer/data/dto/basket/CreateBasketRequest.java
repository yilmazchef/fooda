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
public class CreateBasketRequest {

    String session;

    CreateCustomerRequest customer;

    CreateStoreRequest store;

    // it can be only one product or more product. you can update to add new products.
    Set<CreateProductRequest> products = new LinkedHashSet<>();

        

    public CreateBasketRequest withSession(String session) {
        setSession(session);
        return this;
    }

    public CreateBasketRequest withCustomer(CreateCustomerRequest customer) {
        setCustomer(customer);
        return this;
    }

    public CreateBasketRequest withStore(CreateStoreRequest store) {
        setStore(store);
        return this;
    }

    public CreateBasketRequest withProducts(Set<CreateProductRequest> products) {
        setProducts(products);
        return this;
    }


    //update
    //Set<CreatePaymentRequest> payments = new LinkedHashSet<>();
}
