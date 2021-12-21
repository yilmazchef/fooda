package be.fooda.frontend.customer.data.dto.basket;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdatePaymentRequest {

    Long paymentId;
    BigDecimal amount;
    Boolean isPaid;

    public UpdatePaymentRequest withPaymentId(Long paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public UpdatePaymentRequest withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public UpdatePaymentRequest withPaid(Boolean paid) {
        isPaid = paid;
        return this;
    }
}
