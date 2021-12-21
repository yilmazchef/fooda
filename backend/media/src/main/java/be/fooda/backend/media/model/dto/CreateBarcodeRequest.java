package be.fooda.backend.media.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

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
public class CreateBarcodeRequest implements Serializable {

    Long userId;

    String text;

    Integer width;

    Integer height;

}
