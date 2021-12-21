package be.fooda.backend.media.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateVideoRequest implements Serializable {

    Long userId;

    Long relatedId;

    String type;

    Double width;

    Double height;

    String url;

    String extension;

    Boolean isResponsive;

    Boolean isPublic;

    Double duration;

    String streamUrl;

    String downloadUrl;

    String title;

    String description;

}
