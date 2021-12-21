package be.fooda.frontend.customer.data.dto.basket;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreResponse {

    Long id;
    Long storeId;
    String storeName;
    String storeLogoUrl;
    Long addressId;
    String postcode;
    Long contactId;
    String email;

    public StoreResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public StoreResponse withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public StoreResponse withAddressId(Long addressId) {
        this.addressId = addressId;
        return this;
    }

    public StoreResponse withContactId(Long contactId) {
        this.contactId = contactId;
        return this;
    }

    public StoreResponse withStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    public StoreResponse withStoreLogoUrl(String storeLogoUrl) {
        this.storeLogoUrl = storeLogoUrl;
        return this;
    }

    public StoreResponse withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public StoreResponse withEmail(String email) {
        this.email = email;
        return this;
    }
}
