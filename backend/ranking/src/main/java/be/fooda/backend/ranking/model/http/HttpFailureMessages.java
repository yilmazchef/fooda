package be.fooda.backend.ranking.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpFailureMessages {
    CUSTOMER_RANKING_NOT_FOUND("Customer ranking NOT found!"),
    CUSTOMER_RANKING_DOES_NOT_EXIST("Customer ranking does NOT exist"),
    CUSTOMER_RANKING_EXIST_CANNOT_BE_CREATED("Customer ranking exists, cannot be created."),
    CUSTOMER_RANKING_EXIST_CANNOT_BE_UPDATED("Customer ranking does NOT exist, can NOT be updated!");

    private final String description;
}
