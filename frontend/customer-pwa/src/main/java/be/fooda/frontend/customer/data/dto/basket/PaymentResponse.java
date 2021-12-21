package be.fooda.frontend.customer.data.dto.basket;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {

    Long id;
    Long paymentId;
    BigDecimal amount;
    Boolean isPaid;

    public PaymentResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public PaymentResponse withPaymentId(Long paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public PaymentResponse withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public PaymentResponse withPaid(Boolean paid) {
        isPaid = paid;
        return this;
    }
}
