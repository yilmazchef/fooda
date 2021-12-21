package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreResponse {

    Long id;
    Long storeId;
    String name;

    public StoreResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public StoreResponse withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public StoreResponse withName(String name) {
        this.name = name;
        return this;
    }
}