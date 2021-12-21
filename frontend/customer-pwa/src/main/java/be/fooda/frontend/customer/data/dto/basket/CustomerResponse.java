package be.fooda.frontend.customer.data.dto.basket;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {

    Long id;
    Long customerId;
    Long billingAddressId;
    Long deliveryAddressId;
    Long billingContactId;
    Long deliveryContactId;


    public CustomerResponse withId(Long id) {
        setId(id);
        return this;
    }

    public CustomerResponse withCustomerId(Long customerId) {
        setCustomerId(customerId);
        return this;
    }

    public CustomerResponse withBillingAddressId(Long billingAddressId) {
        setBillingAddressId(billingAddressId);
        return this;
    }

    public CustomerResponse withDeliveryAddressId(Long deliveryAddressId) {
        setDeliveryAddressId(deliveryAddressId);
        return this;
    }

    public CustomerResponse withBillingContactId(Long billingContactId) {
        setBillingContactId(billingContactId);
        return this;
    }

    public CustomerResponse withDeliveryContactId(Long deliveryContactId) {
        setDeliveryContactId(deliveryContactId);
        return this;
    }

}
