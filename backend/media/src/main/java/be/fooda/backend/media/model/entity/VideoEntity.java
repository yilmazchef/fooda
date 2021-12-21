package be.fooda.backend.media.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
// JPA
@Entity(name = "videos")
public class VideoEntity extends MediaEntity {

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
