package be.fooda.backend.review.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCustomerRequest {

    Long customerId;
    String review;
    String session;
    Long billingAddressId;
    Long deliveryAddressId;
    Long billingContactId;
    Long deliveryContactId;
}
