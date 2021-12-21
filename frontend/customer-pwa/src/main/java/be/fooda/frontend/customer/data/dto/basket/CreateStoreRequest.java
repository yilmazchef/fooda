package be.fooda.frontend.customer.data.dto.basket;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateStoreRequest {

    Long storeId;
    Long addressId;
    Long contactId;


    public CreateStoreRequest withStoreId(Long storeId) {
        setStoreId(storeId);
        return this;
    }

    public CreateStoreRequest withAddressId(Long addressId) {
        setAddressId(addressId);
        return this;
    }

    public CreateStoreRequest withContactId(Long contactId) {
        setContactId(contactId);
        return this;
    }

}
