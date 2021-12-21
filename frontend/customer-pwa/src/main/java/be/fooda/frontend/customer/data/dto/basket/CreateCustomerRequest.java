package be.fooda.frontend.customer.data.dto.basket;


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


    public CreateCustomerRequest withCustomerId(Long customerId) {
        setCustomerId(customerId);
        return this;
    }

    public CreateCustomerRequest withBillingAddressId(Long billingAddressId) {
        setBillingAddressId(billingAddressId);
        return this;
    }

    public CreateCustomerRequest withDeliveryAddressId(Long deliveryAddressId) {
        setDeliveryAddressId(deliveryAddressId);
        return this;
    }

    public CreateCustomerRequest withBillingContactId(Long billingContactId) {
        setBillingContactId(billingContactId);
        return this;
    }

    public CreateCustomerRequest withDeliveryContactId(Long deliveryContactId) {
        setDeliveryContactId(deliveryContactId);
        return this;
    }

}
