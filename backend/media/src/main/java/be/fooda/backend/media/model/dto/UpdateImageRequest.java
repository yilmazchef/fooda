package be.fooda.backend.media.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.sql.Blob;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@Jacksonized
public class UpdateImageRequest implements Serializable {

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

    Blob dataAsByte;

    String altText;

}
