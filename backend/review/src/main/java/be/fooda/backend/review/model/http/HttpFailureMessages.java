package be.fooda.backend.review.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpFailureMessages {
    CUSTOMER_REVIEW_NOT_FOUND("Customer review NOT found!"),
    CUSTOMER_REVIEW_DOES_NOT_EXIST("Customer review does NOT exist"),
    CUSTOMER_REVIEW_EXIST_CANNOT_BE_CREATED("Customer review exists, cannot be created."),
    CUSTOMER_REVIEW_EXIST_CANNOT_BE_UPDATED("Customer review does NOT exist, can NOT be updated!");

    private final String description;
}
