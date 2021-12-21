package be.fooda.backend.order.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    PROCESSING(""),

    // KITCHEN
    WAITING_FOR_CONFIRMATION(""),
    CONFIRMED_BY_KITCHEN(""),
    BEING_PREPARED_FOR_COOKING(""),
    COOKING_IS_COMPLETED(""),

    // DELIVERY
    ON_DELIVERY_PARENT("The order is on delivery"),
    ON_DELIVERY_BEING_PREPARED("The order is being prepared"),
    ON_DELIVERY_COURIER("Courier picked the order up"),
    ON_DELIVERY_ARRIVED("The courier has arrived to destination"),
    ON_DELIVERY_ADDRESS_VERIFY("The courier has tried to deliver the order, " +
            "but the address was not found. Validation needed"),
    DELIVERY_IS_COMPLETED("The customer successfully received the order"),

    // PAYMENT
    PAYMENT_RECEIVED_BY_CASH(""),
    PAYMENT_FAILED_BY_CASH(""),
    PAYMENT_RECEIVED_BY_DEBIT_CARD(""),
    PAYMENT_FAILED_BY_DEBIT_CARD(""),
    PAYMENT_RECEIVED_BY_CREDIT_CARD(""),
    PAYMENT_FAILED_BY_CREDIT_CARD(""),
    PAYMENT_RECEIVED_BY_PAYPAL(""),
    PAYMENT_FAILED_BY_PAYPAL(""),
    PAYMENT_RECEIVED_BY_BANCONTACT(""),
    PAYMENT_FAILED_BY_BANCONTACT(""),
    PAYMENT_RECEIVED_BY_FOODA_COIN(""),
    PAYMENT_FAILED_BY_FOODA_COIN(""),
    PAYMENT_RECEIVED_BY_MONERO(""),
    PAYMENT_FAILED_BY_MONERO(""),
    PAYMENT_IS_COMPLETED(""),

    // COMPLETED
    ORDER_IS_COMPLETED(""),

    // CANCELLER
    ORDER_IS_CANCELLED("");

    private final String description;
}
