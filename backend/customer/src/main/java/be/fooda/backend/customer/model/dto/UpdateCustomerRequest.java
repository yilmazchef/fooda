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
public class UpdateCustomerRequest {

    Long id;
    Boolean isActive = Boolean.TRUE;
    String validation;
    String firstName;
    String familyName;
    String dateOfBirth;
    String registeredAt;
    String updatedAt;
    String note;
    Long userId;
    Long addressId;
    Long contactId;
    Set<Long> paymentOptions;
    Set<Long> favoriteProducts;
    Set<Long> favoriteOrders;
    Set<Long> favoriteStores;
}
