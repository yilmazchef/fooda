package be.fooda.backend.payment.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FoodaPaymentHttpSuccessMessages {
    PAYMENT_CREATED("Payment with the given information is created"),
    PAYMENT_UPDATED("Payment with the given information updated"),
    PAYMENT_LIST_DELETED("List of Payments with the given information deleted"),
    PAYMENT_EXISTS("Payment with the given information exists"),
    PAYMENT_ITEM_DELETED("Payment item with the given information deleted"),
    PAYMENT_ITEM_LIST_DELETED("List of Payment items with the given information deleted"),
    PAYMENT_ITEM_EXISTS("Payment item with the given information exists"),
    PAYMENT_ITEM_UPDATED("Payment item with the given information updated"),
    PAYMENT_ORDER_UPDATED("Payment order with the given information updated"),
    PAYMENT_ORDER_DELETED("Payment order with the given information deleted"),
    PAYMENT_ORDER_LIST_DELETED("List of Payment orders with the given information deleted"),
    PAYMENT_ORDER_EXISTS("Payment order with the given information exists"),
    PAYMENT_STORE_UPDATED("Payment store with the given information updated"),
    PAYMENT_STORE_DELETED("Payment store with the given information deleted"),
    PAYMENT_STORE_LIST_DELETED("List of Payment stores with the given information deleted"),
    PAYMENT_STORE_EXISTS("Payment store with the given information exists"),
    PAYMENT_USER_UPDATED("Payment user with the given information updated"),
    PAYMENT_USER_DELETED("Payment user with the given information deleted"),
    PAYMENT_DELETED("Payment with the given information deleted"),
    PAYMENT_USER_LIST_DELETED("List of Payment users with the given information deleted"),
    PAYMENT_USER_EXISTS("Payment user with the given information exists");

    private final String description;
}
