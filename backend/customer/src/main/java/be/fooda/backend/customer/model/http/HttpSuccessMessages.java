package be.fooda.backend.customer.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpSuccessMessages {

    CUSTOMER_EXISTS("Customer exists"),
    CUSTOMER_CREATED("Customer CREATED based on the given information"),
    CUSTOMER_UPDATED("Customer successfully updated"),
    CUSTOMER_DELETED("Customer deleted"),
    CUSTOMER_IS_VALID("Customer phone is valid"),
    CUSTOMER_FAVORITE_PRODUCT_ADDED("Customer product added successfully");
    private final String description;
}
