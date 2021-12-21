package be.fooda.backend.contact.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpFailureMassages {
    USER_DOES_NOT_EXIST("There is no such user with the given information"),
    STORE_DOES_NOT_EXIST("There is no such store with the given information"),
    Contact_CREATE_ERROR("There was an error while Contact is being created.."),
    Contact_ALREADY_EXIST("The Contact already exists.."),
    PROBLEM_WITH_CREATING_IN_DB("There has been a problem while creating the Contact in the database.."),
    MEDIA_DOES_NOT_EXIST("MEDIA does not exist."),
    NO_ContactS_FOUND("Could not found Contact with the given information"),
    UNKNOWN_FAILURE("  An unknown exception happened."),
    NO_ContactS_IS_FEATURED("no Contact is featured"),
    FAILED_TO_CREATE_Contact("There has been a problem while creating the Contact"),
    Contact_DOES_NOT_EXIST("There is no such Contact  "),
    Contact_COULD_NOT_BE_DELETED("there some error in deleting the Contact"),
    SOME_ContactS_EXIST_FROM_THE_LIST("Some of the Contacts exist in the list."),
    Contact_NOT_FOUND("Contact could not found"),
    NO_FIELD_IS_SENT_TO_UPDATE_REQUEST("...... "),
    NO_STORE_FOUND("store not found"),
    NO_CATEGORIES_FOUND(" category is not found"),
    NO_INGREDIENTS_FOUND("ingredients not found"),
    NO_TAGS_FOUND("no tags is found"),
    CATEGORY_NOT_FOUND("category not found"),
    CATEGORY_COULD_NOT_BE_DELETED("category can not be deleted"),
    CATEGORY_DOES_NOT_EXIST("category do not exist"),
    INGREDIENT_ALREADY_EXIST("ingredient is not exist"),
    TAG_ALREADY_EXIST("tag already is added"),
    INGREDIENT_DOES_NOT_EXIST("ingredient does not exist"),
    INGREDIENT_COULD_NOT_BE_DELETED("ingredient can not be deleted"),
    TAG_DOES_NOT_EXIST("tag does not exist"),
    NO_Contact_PRICE_IS_FOUND("no price is found for this Contact"), TAX_DOES_NOT_EXIST(""),
    FAILED_TO_UPDATE_Contact("There has been a problem while updating the Contact"), 
    Contact_ID_IS_REQUIRED("Contact ID is required"), 
    Contact_TITLE_IS_REQUIRED("Contact title is required"), 
    STORE_ID_IS_REQUIRED("Store ID is required"),
    Contact_IS_REQUIRED("Contact information is required"),
    FAILED_TO_MAKE_Contact_PASSIVE("Failed to make Contact passive"),
    FAILED_TO_DELETE_Contact_PERMANENTLY("Failed to delete Contact permanently");

    private final String description;
}
