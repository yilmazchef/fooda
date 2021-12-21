package be.fooda.frontend.customer.data.dto.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageResponse implements Serializable {

    Long imageId;

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

    public ImageResponse withUrl(String url) {
        this.url = url;
        return this;
    }

    public ImageResponse withAltText(String altText) {
        this.altText = altText;
        return this;
    }
}
