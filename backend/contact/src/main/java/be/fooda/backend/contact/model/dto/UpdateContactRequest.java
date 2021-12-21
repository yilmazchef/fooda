package be.fooda.backend.contact.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateContactRequest implements Serializable {

    Long id;

    Long userId;

    String firstName;

    String familyName;

    String companyName;

    String mobilePhoneNumber;

    String linePhoneNumber;

    String email;

    Boolean canCall;

    Boolean isActive;

    String title;

    Boolean isCurrent;

}
