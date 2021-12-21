package be.fooda.backend.media.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Lob;
import java.sql.Blob;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
// JPA
@Entity(name = "images")
public class ImageEntity extends MediaEntity {

    @Lob
    Blob dataAsByte;

    String altText;

}
