package be.fooda.backend.media.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpFailureMassages {
    USER_DOES_NOT_EXIST("There is no such user with the given information"),
    MEDIA_CREATE_ERROR("There was an error while PRODUCT is being created.."),
    MEDIA_ALREADY_EXIST("The media already exists.."),
    MEDIA_IS_REQUIRED("Media info is required.."),
    MEDIA_ID_IS_REQUIRED("Media ID is required.."),
    MEDIA_USER_ID_IS_REQUIRED("Media title is required"),
    PROBLEM_WITH_CREATING_IN_DB("There has been a problem while creating the MEDIA in the database.."),
    UNKNOWN_FAILURE("An unknown exception happened."),
    MEDIA_NOT_FOUND("media not found"),
    NO_MEDIAS_FOUND(""),
    MEDIA_DOES_NOT_EXIST(""),
    MEDIA_COULD_NOT_BE_DELETED(""),
    FAILED_TO_UPDATE_MEDIA("Media update request is failed."),
    MEDIA_RELATED_ID_IS_REQUIRED("Media Related ID is required"),
    IMAGE_BY_ID_NOT_FOUND("Image with the requested ID is NOT found."),
    BARCODE_COULD_NOT_BE_CREATED("Barcode could not be created.."),
    IMAGE_NOT_FOUND("Image not found.."),
    MEDIA_NAME_IS_TOO_LONG("Media name is too long. Please try to give a name with less than 255 characters..");

    private final String description;
}
