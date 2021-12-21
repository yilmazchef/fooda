package be.fooda.backend.media.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Jacksonized
public class UpdateVideoRequest implements Serializable {

    Long userId;

    Long relatedId;

    String type;

    Double width;

    Double height;

    String url;

    String extension;

    String createdAt;

    String updatedAt;

    Boolean isResponsive;

    Boolean isVisible;

    Boolean isPublic;

    Boolean isActive;

    Double duration;

    String streamUrl;

    String downloadUrl;

    String title;

    String description;

}
