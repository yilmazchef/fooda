package be.fooda.backend.courier.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpFailureMessages {

    COURIER_ALREADY_EXIST("Courier already exists."),
    COURIER_DOES_NOT_EXIST("Courier does not exist"),
    PAYMENT_DOES_NOT_EXIST("Payment does not exist"),
    STORE_DOES_NOT_EXIST("Store does not exist"),
    ORDER_DOES_NOT_EXIST("Order does not exist"),
    USER_DOES_NOT_EXIST("User does not exist"),
    CONTACT_DOES_NOT_EXIST("Contact does not exist"),
    ADDRESS_DOES_NOT_EXIST("Address does not exist"),
    MISSING_PRODUCT_SET("Products do not exist"),
    MISSING_PAYMENT_SET("Payments do not exist"),
    NO_COURIERS_FOUND("No customers found"),
    COURIER_COULD_NOT_BE_DELETED("Courier could not be deleted"),
    COURIERS_COULD_NOT_BE_DELETED("Couriers could not be deleted"),
    COURIER_PRODUCT_DOES_NOT_EXISTS("Courier product does not exists"),
    COURIER_COULD_NOT_BE_VALIDATED("Courier could not be validated"),
    COURIER_PRODUCT_ALREADY_EXISTS("Courier product already exists"),
    COURIER_IS_REQUIRED("Courier information is required"),
    COURIER_ID_IS_REQUIRED("Courier ID is required"),
    COURIER_FIRST_NAME_IS_REQUIRED("Courier first name is required"),
    COURIER_FAMILY_NAME_IS_REQUIRED("Courier family name is required");

    private final String description;
}