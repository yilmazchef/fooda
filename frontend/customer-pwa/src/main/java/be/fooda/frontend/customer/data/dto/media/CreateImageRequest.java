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
public class CreateImageRequest implements Serializable {

    Long userId;

    Long relatedId;

    Blob dataAsByte;

    String altText;

    String type;

    Double width;

    Double height;

    String url;

    String extension;

    Boolean isResponsive;

    Boolean isPublic;

}
