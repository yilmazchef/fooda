package be.fooda.frontend.customer.data.dto.media;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Jacksonized
public class VideoResponse implements Serializable {

    Long videoId;

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

    @NotNull
    Double duration;

    String streamUrl;

    @NotNull
    String downloadUrl;

    @NotEmpty @NotNull
    String title;

    @Lob
    String description;

}
