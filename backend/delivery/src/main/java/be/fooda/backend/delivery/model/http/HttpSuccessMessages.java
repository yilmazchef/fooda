package be.fooda.backend.delivery.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.aop.config.AdvisorComponentDefinition;

@Getter
@AllArgsConstructor
public enum HttpSuccessMessages {

    DELIVERY_EXISTS("Delivery exists"),
    DELIVERY_CREATED("Delivery is CREATED  based on the given information"),
    DELIVERY_UPDATED("Delivery is successfully updated"),
    DELIVERY_DELETED("Delivery is deleted"),
    DELIVERY_STATUS_UPDATED("Delivery status is updated"),
    DELIVERY_PAYMENT_STATUS_UPDATED("Delivery payment status is updated"),
    DELIVERY_PRODUCT_ADDED("Delivery added successfully"),
    DELIVERY_MADE_PASSIVE("Delivery is made passive successfully"),
    DELIVERIES_DELETED("Orders are deleted");


    private final String description;
}
