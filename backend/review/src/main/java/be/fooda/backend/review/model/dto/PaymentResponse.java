package be.fooda.backend.review.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {

    String id;
    Long paymentId;
    String review;
    String session;
    BigDecimal amount;
    Boolean isPaid;
}
