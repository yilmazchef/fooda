package be.fooda.frontend.customer.data.dto.contact;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.util.Objects;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateContactRequest {
    

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
        if (!(o instanceof UpdateContactRequest)) return false;
        UpdateContactRequest that = (UpdateContactRequest) o;
        return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getFamilyName(), that.getFamilyName()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getFamilyName(), getEmail());
    }
}