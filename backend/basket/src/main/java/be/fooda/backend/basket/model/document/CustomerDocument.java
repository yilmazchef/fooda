package be.fooda.backend.basket.model.document;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(value = "customer_document")
public class CustomerDocument {

    Long customerId;
    Long billingAddressId;
    Long deliveryAddressId;
    Long billingContactId;
    Long deliveryContactId;

    Boolean active;
}
