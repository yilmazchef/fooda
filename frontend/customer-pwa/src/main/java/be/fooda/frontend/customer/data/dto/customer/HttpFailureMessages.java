package be.fooda.frontend.customer.data.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpFailureMessages {

    CUSTOMER_ALREADY_EXIST("Customer already exists."),
    CUSTOMER_DOES_NOT_EXIST("Customer does not exist"),
    PAYMENT_DOES_NOT_EXIST("Payment does not exist"),
    STORE_DOES_NOT_EXIST("Store does not exist"),
    ORDER_DOES_NOT_EXIST("Order does not exist"),
    USER_DOES_NOT_EXIST("User does not exist"),
    CONTACT_DOES_NOT_EXIST("Contact does not exist"),
    ADDRESS_DOES_NOT_EXIST("Address does not exist"),
    MISSING_PRODUCT_SET("Products do not exist"),
    MISSING_PAYMENT_SET("Payments do not exist"),
    NO_CUSTOMERS_FOUND("No customers found"),
    CUSTOMER_COULD_NOT_BE_DELETED("Customer could not be deleted"),
    CUSTOMERS_COULD_NOT_BE_DELETED("Customers could not be deleted"),
    CUSTOMER_PRODUCT_DOES_NOT_EXISTS("Customer product does not exists"),
    CUSTOMER_COULD_NOT_BE_VALIDATED("Customer could not be validated"),
    CUSTOMER_PRODUCT_ALREADY_EXISTS("Customer product already exists"),
    CUSTOMER_IS_REQUIRED("Customer information is required"),
    CUSTOMER_ID_IS_REQUIRED("Customer ID is required"),
    CUSTOMER_FIRST_NAME_IS_REQUIRED("Customer first name is required"),
    CUSTOMER_FAMILY_NAME_IS_REQUIRED("Customer family name is required");

    private final String description;
}