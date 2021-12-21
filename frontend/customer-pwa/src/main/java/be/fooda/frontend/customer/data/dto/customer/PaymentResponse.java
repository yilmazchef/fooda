package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {

    Long id;
    Long paymentId;
    String method;
    Boolean isDefault;

    public PaymentResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public PaymentResponse withPaymentId(Long paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public PaymentResponse withMethod(String method) {
        this.method = method;
        return this;
    }

    public PaymentResponse withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }
}