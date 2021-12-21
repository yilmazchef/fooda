package be.fooda.backend.delivery.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.aop.config.AdvisorComponentDefinition;

@Getter
@AllArgsConstructor
public enum HttpFailureMessages {

    DELIVERY_ALREADY_EXIST("Delivery already exists."),
    DELIVERY_DOES_NOT_EXIST("Delivery does not exist"),
    DELIVERY_STATUS_NOT_EXIST("Delivery status does not exist"),
    PAYMENT_DOES_NOT_EXIST("Payment does not exist"),
    CUSTOMER_DOES_NOT_EXIST("Customer does not exist"),
    STORE_DOES_NOT_EXIST("Store does not exist"),
    ORDER_DOES_NOT_EXIST("Order does not exist"),
    MISSING_PRODUCT_SET("Products do not exist"),
    COURIER_DOES_NOT_EXIST("Courier does not exist"),
    NO_DELIVERIES_FOUND("No deliveries found"),
    DELIVERY_COULD_NOT_BE_DELETED("Delivery could not be deleted"),
    DELIVERIES_COULD_NOT_BE_DELETED("Deliveries could not be deleted"),
    DELIVERY_PRODUCT_DOES_NOT_EXISTS("Delivery product does not exists"),
    DELIVERY_PRODUCT_ALREADY_EXISTS("Delivery product already exists"),
    ORDER_ID_IS_REQUIRED("Order ID is required."),
    DELIVERY_ID_IS_REQUIRED("Delivery ID is required"),
    DELIVERY_IS_REQUIRED("Delivery is required."),
    DELIVERY_NOT_FOUND("Delivery was not found."),
    FAILED_TO_UPDATE_DELIVERY("Failed to update delivery"),
    STORE_ID_IS_REQUIRED("Store ID is required."),
    FAILED_TO_MAKE_DELIVERY_PASSIVE("Failed to make delivery passive.");


    private final String description;
}
