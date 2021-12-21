package be.fooda.backend.customer.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;
import java.util.List;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {

    Long id;
    Boolean isActive = Boolean.TRUE;
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
}
