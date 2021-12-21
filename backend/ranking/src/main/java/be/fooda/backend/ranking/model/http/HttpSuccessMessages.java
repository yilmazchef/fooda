package be.fooda.backend.ranking.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpSuccessMessages {
    CUSTOMER_RANKING_CREATED("Customer ranking is created."),
    CUSTOMER_RANKING_UPDATED("Customer ranking is updated."),
    CUSTOMER_RANKING_DELETED("Customer ranking is deleted."),
    CUSTOMER_RANKING_EXISTS("Customer ranking exists");

    private final String description;
}
