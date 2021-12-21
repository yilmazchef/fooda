package be.fooda.backend.media.model.dto;

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
public class VideoExistenceRequest implements Serializable {

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
