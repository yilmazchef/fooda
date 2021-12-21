package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

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

    public AddressResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public AddressResponse withAddressId(Long addressId) {
        this.addressId = addressId;
        return this;
    }

    public AddressResponse withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public AddressResponse withMunicipality(String municipality) {
        this.municipality = municipality;
        return this;
    }

    public AddressResponse withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }
}