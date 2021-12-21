package be.fooda.frontend.customer.data.dto.order;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"storeId"})
// TODO Do I need this response object?
public class StoreResponse implements Serializable {

    Long storeId;
    String storeName;
}