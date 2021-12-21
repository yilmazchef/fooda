package be.fooda.backend.payment.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpSuccessMessages {
    PAYMENT_CREATED("Payment is created based on the given information"),
    PAYMENT_UPDATED("Payment successfully updated"),
    PAYMENT_DELETED("Payment deleted based on the new information"),
    PAYMENT_MADE_PASSIVE("Payment is made passive."),
    PAYMENT_LIST_CREATED("All Payments from the list are created.. "),
    PAYMENT_CATEGORY_ADDED("Category is added to the payment"),
    PAYMENT_EXISTS("Payment already exists."),
    CATEGORY_DELETED("category is deleted"),
    INGREDIENT_ADDED("ingredient is added"),
    TAG_ADDED("tag is added"),
    INGREDIENT_DELETED("ingredient is deleted"),
    PAYMENT_INGREDIENT_ADDED("ingredient is added to payment"),
    PAYMENT_TAG_ADDED("tag is added to payment"),
    TAG_DELETED("tag is deleted"),
    PAYMENT_PRICE_ADDED("price added to th payment"),
    TAX_DELETED("tax deleted"), PAYMENT_TAX_ADDED("tax added to payment");

    private final String description;
}
