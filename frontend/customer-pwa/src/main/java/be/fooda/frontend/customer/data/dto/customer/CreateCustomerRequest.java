package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

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

    public CreateCustomerRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateCustomerRequest withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateCustomerRequest withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public CreateCustomerRequest withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public CreateCustomerRequest withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CreateCustomerRequest withNote(String note) {
        this.note = note;
        return this;
    }

    public CreateCustomerRequest withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public CreateCustomerRequest withAddressId(Long addressId) {
        this.addressId = addressId;
        return this;
    }

    public CreateCustomerRequest withContactId(Long contactId) {
        this.contactId = contactId;
        return this;
    }
}
