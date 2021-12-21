package be.fooda.backend.courier.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpSuccessMessages {

    COURIER_EXISTS("Courier exists"),
    COURIER_CREATED("Courier CREATED based on the given information"),
    COURIER_UPDATED("Courier successfully updated"),
    COURIER_DELETED("Courier deleted"),
    COURIER_IS_VALID("Courier phone is valid"),
    COURIER_FAVORITE_PRODUCT_ADDED("Courier product added successfully");
    private final String description;
}
