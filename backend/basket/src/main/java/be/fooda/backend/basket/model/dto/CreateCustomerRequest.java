package be.fooda.backend.basket.model.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCustomerRequest {

    Long customerId;
    Long billingAddressId;
    Long deliveryAddressId;
    Long billingContactId;
    Long deliveryContactId;
}
