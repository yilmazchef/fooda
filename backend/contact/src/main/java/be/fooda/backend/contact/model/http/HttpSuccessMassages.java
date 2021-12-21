package be.fooda.backend.contact.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpSuccessMassages {
    Contact_CREATED("Contact is created based on the given information"),
    Contact_UPDATED("Contact successfully updated"),
    Contact_DELETED("Contact deleted based on the new information"),
    Contact_MADE_PASSIVE("Contact is made passive."),
    Contact_LIST_CREATED("All Contacts from the list are created.. "),
    Contact_CATEGORY_ADDED("Category is added to the Contact"),
    Contact_EXISTS("Contact already exists."),
    CATEGORY_DELETED("category is deleted"),
    INGREDIENT_ADDED("ingredient is added"),
    TAG_ADDED("tag is added"),
    INGREDIENT_DELETED("ingredient is deleted"),
    Contact_INGREDIENT_ADDED("ingredient is added to Contact"),
    Contact_TAG_ADDED("tag is added to Contact"),
    TAG_DELETED("tag is deleted"),
    Contact_PRICE_ADDED("price added to th Contact"),
    TAX_DELETED("tax deleted"), Contact_TAX_ADDED("tax added to Contact");

    private final String description;
}
