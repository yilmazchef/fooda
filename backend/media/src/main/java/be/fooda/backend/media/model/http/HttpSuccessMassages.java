package be.fooda.backend.media.model.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpSuccessMassages {
    MEDIA_CREATED("MEDIA added "),
    MEDIA_UPDATED("MEDIA successfully updated"),
    MEDIA_DELETED("MEDIA deleted "),
    MEDIA_EXISTS("MEDIA exists");

    private final String description;
}
