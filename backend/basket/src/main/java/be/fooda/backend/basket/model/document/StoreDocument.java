package be.fooda.backend.basket.model.document;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
public class StoreDocument {

    Long storeId;
    Long addressId;
    Long contactId;

    Boolean active;
}
