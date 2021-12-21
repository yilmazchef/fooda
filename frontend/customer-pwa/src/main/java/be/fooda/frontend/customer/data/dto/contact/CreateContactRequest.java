package be.fooda.frontend.customer.data.dto.contact;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.util.Objects;
import java.util.UUID;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateContactRequest {


    UUID externalUserId;

    String firstName;

    String familyName;

    String companyName;

    String mobilePhoneNumber;

    String linePhoneNumber;

    String email;

    Boolean canCall;

    String title;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateContactRequest)) return false;
        CreateContactRequest that = (CreateContactRequest) o;
        return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getFamilyName(), that.getFamilyName()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getFamilyName(), getEmail());
    }
}