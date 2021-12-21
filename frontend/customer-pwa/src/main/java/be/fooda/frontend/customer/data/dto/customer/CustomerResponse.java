package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {

    Long id;
    Boolean isActive;
    String title;

    String firstName;
    String familyName;
    String dateOfBirth;
    String createdAt;
    String updatedAt;
    String note;
    String validation;
    String companyName;
    UserResponse user;
    Long userId;
    AddressResponse currentAddress;
    ContactResponse currentContact;
    List<PaymentResponse> paymentOptions;
    List<ProductResponse> favoriteProducts;
    List<OrderResponse> favoriteOrders;
    List<StoreResponse> favoriteStores;

    public CustomerResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public CustomerResponse withActive(Boolean active) {
        isActive = active;
        return this;
    }

    public CustomerResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomerResponse withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerResponse withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public CustomerResponse withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public CustomerResponse withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public CustomerResponse withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public CustomerResponse withNote(String note) {
        this.note = note;
        return this;
    }

    public CustomerResponse withValidation(String validation) {
        this.validation = validation;
        return this;
    }

    public CustomerResponse withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CustomerResponse withUser(UserResponse user) {
        this.user = user;
        return this;
    }

    public CustomerResponse withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public CustomerResponse withCurrentAddress(AddressResponse currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public CustomerResponse withCurrentContact(ContactResponse currentContact) {
        this.currentContact = currentContact;
        return this;
    }

    public CustomerResponse withPaymentOptions(List<PaymentResponse> paymentOptions) {
        this.paymentOptions = paymentOptions;
        return this;
    }

    public CustomerResponse withFavoriteProducts(List<ProductResponse> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
        return this;
    }

    public CustomerResponse withFavoriteOrders(List<OrderResponse> favoriteOrders) {
        this.favoriteOrders = favoriteOrders;
        return this;
    }

    public CustomerResponse withFavoriteStores(List<StoreResponse> favoriteStores) {
        this.favoriteStores = favoriteStores;
        return this;
    }
}
