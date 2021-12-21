package be.fooda.backend.customer.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCustomerRequest {

    String title;
    String firstName;
    String familyName;
    String dateOfBirth;
    String companyName;
    String note;
    Long userId;
    Long addressId;
    Long contactId;

}
