package be.fooda.backend.review.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpSuccessMessages {
    CUSTOMER_REVIEW_CREATED("Customer review is created."),
    CUSTOMER_REVIEW_UPDATED("Customer review is updated."),
    CUSTOMER_REVIEW_DELETED("Customer review is deleted."),
    CUSTOMER_REVIEW_EXISTS("Customer review exists");

    private final String description;
}
