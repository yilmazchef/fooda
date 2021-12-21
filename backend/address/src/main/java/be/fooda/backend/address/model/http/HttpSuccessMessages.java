package be.fooda.backend.address.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpSuccessMessages {
    ADDRESS_ADDED("Address is added"),
    ADDRESS_DELETED("Address is deleted"),
    ADDRESS_CREATED("Address is created based on the given information"),
    ADDRESS_UPDATED("Address successfully updated"),
    ADDRESS_MADE_PASSIVE("Address is made passive."),
    ADDRESS_LIST_CREATED("All Addresses from the list are created.. "),
    ADDRESS_CATEGORY_ADDED("Category is added to the address"),
    ADDRESS_EXISTS("Address exists"),
    CATEGORY_DELETED("category is deleted"),
    INGREDIENT_ADDED("ingredient is added"),
    TAG_ADDED("tag is added"),
    INGREDIENT_DELETED("ingredient is deleted"),
    ADDRESS_INGREDIENT_ADDED("ingredient is added to address"),
    ADDRESS_TAG_ADDED("tag is added to address"),
    TAG_DELETED("tag is deleted"),
    ADDRESS_PRICE_ADDED("price added to th address"),
    TAX_DELETED("tax deleted"),
    ADDRESS_TAX_ADDED("tax added to address");

    private final String description;
}
