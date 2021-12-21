package be.fooda.backend.payment.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FoodaPaymentHttpFailureMessages {
    PAYMENT_DOES_NOT_EXIST("Payment with the given information does not exist"),
    NO_PAYMENTS_FOUND("No payments found"),
    NO_PAYMENT_FOUND("Given payment could not be found"),
    PAYMENT_COULD_NOT_BE_CREATED("For an unknown reason, given payment could not be created"),
    PAYMENT_COULD_NOT_BE_DELETED("For an unknown reason, given payment could not be deleted"),
    PAYMENT_LIST_COULD_NOT_BE_DELETED("For an unknown reason, given list of payments could not be deleted"),
    PAYMENT_ITEM_DOES_NOT_EXIST("Payment item with the given information does not exist"),
    PAYMENT_ITEM_COULD_NOT_BE_CREATED("For an unknown reason, given payment item could not be created"),
    PAYMENT_HAS_NO_PAYMENT_ITEMS("Given payment has no payment items"),
    PAYMENT_ITEM_COULD_NOT_BE_DELETED("For an unknown reason, given payment item could not be deleted"),
    PAYMENT_ITEM_LIST_COULD_NOT_BE_DELETED("For an unknown reason, given list of payment items could not be deleted"),
    NO_PAYMENT_ITEM_FOUND("Given payment item could not be found"),
    NO_PAYMENT_ITEMS_FOUND("No payment items found"),
    NO_PAYMENT_ORDERS_FOUND("No payment orders found"),
    PAYMENT_ORDER_COULD_NOT_BE_CREATED("For an unknown reason, given payment order could not be created"),
    PAYMENT_ORDER_COULD_NOT_BE_DELETED("For an unknown reason, given payment order could not be deleted"),
    PAYMENT_ORDER_DOES_NOT_EXIST("Payment order with the given information does not exist"),
    PAYMENT_ORDER_LIST_COULD_NOT_BE_DELETED("For an unknown reason, given list of payment orders could not be deleted"),
    NO_PAYMENT_STORES_FOUND("No payment stores found"),
    PAYMENT_STORE_COULD_NOT_BE_CREATED("For an unknown reason, given payment store could not be created"),
    PAYMENT_STORE_COULD_NOT_BE_DELETED("For an unknown reason, given payment store could not be deleted"),
    PAYMENT_STORE_DOES_NOT_EXIST("Payment store with the given information does not exist"),
    PAYMENT_STORE_LIST_COULD_NOT_BE_DELETED("For an unknown reason, given list of payment stores could not be deleted"),
    PAYMENT_STORES_DOES_NOT_EXIST("Payment stores with the given information does not exist"),
    PAYMENT_USER_COULD_NOT_BE_CREATED("For an unknown reason, given payment user could not be created"),
    PAYMENT_USER_COULD_NOT_BE_DELETED("For an unknown reason, given payment user could not be deleted"),
    PAYMENT_USER_DOES_NOT_EXIST("Payment user with the given information does not exist"),
    PAYMENT_USER_LIST_COULD_NOT_BE_DELETED("For an unknown reason, given list of payment users could not be deleted"),
    PAYMENT_USERS_DOES_NOT_EXIST("Payment users with the given information does not exist"),
    PAYMENT_ALREADY_EXIST("Payment already exist."),
    REQUIRED_FIELDS_ARE_MISSING_IN_CREATE_REQUEST(""),
    REQUIRED_FIELDS_ARE_MISSING_IN_UPDATE_REQUEST(""),
    NO_PRODUCTS_FOUND("No Products Found.. "),
    NO_PAYMENT_USERS_FOUND("No payment users found");

    private final String description;
}
