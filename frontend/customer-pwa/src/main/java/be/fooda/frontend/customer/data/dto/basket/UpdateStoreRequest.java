package be.fooda.frontend.customer.data.dto.basket;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateStoreRequest {

    Long storeId;
    Long addressId;
    Long contactId;

    public UpdateStoreRequest withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public UpdateStoreRequest withAddressId(Long addressId) {
        this.addressId = addressId;
        return this;
    }

    public UpdateStoreRequest withContactId(Long contactId) {
        this.contactId = contactId;
        return this;
    }
}
