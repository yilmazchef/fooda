package be.fooda.backend.customer.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressResponse {

    Long id;
    Long addressId;
    String postcode;
    String municipality;
    Boolean isDefault;
    CustomerResponse customer;
}