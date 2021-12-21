package be.fooda.frontend.customer.data.dto.basket;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateCustomerRequest {

    Long customerId;

    Long billingAddressId;

    Long deliveryAddressId;

    Long billingContactId;

    Long deliveryContactId;

    public UpdateCustomerRequest withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public UpdateCustomerRequest withBillingAddressId(Long billingAddressId) {
        this.billingAddressId = billingAddressId;
        return this;
    }

    public UpdateCustomerRequest withDeliveryAddressId(Long deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
        return this;
    }

    public UpdateCustomerRequest withBillingContactId(Long billingContactId) {
        this.billingContactId = billingContactId;
        return this;
    }

    public UpdateCustomerRequest withDeliveryContactId(Long deliveryContactId) {
        this.deliveryContactId = deliveryContactId;
        return this;
    }
}
