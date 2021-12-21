package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateCustomerRequest {

    Long id;
    String title;
    Boolean isActive = Boolean.TRUE;
    String validation ;
    String firstName;
    String familyName;
    String companyName;
    String dateOfBirth;
    String note;
    Long userId;
    Long addressId;
    Long contactId;
    Set<Long> paymentOptions;
    Set<Long> favoriteProducts;
    Set<Long> favoriteOrders;
    Set<Long> favoriteStores;

    public UpdateCustomerRequest withId(Long id) {
        this.id = id;
        return this;
    }

    public UpdateCustomerRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public UpdateCustomerRequest withActive(Boolean active) {
        isActive = active;
        return this;
    }

    public UpdateCustomerRequest withValidation(String validation) {
        this.validation = validation;
        return this;
    }

    public UpdateCustomerRequest withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UpdateCustomerRequest withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public UpdateCustomerRequest withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public UpdateCustomerRequest withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public UpdateCustomerRequest withNote(String note) {
        this.note = note;
        return this;
    }

    public UpdateCustomerRequest withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public UpdateCustomerRequest withAddressId(Long addressId) {
        this.addressId = addressId;
        return this;
    }

    public UpdateCustomerRequest withContactId(Long contactId) {
        this.contactId = contactId;
        return this;
    }

}
