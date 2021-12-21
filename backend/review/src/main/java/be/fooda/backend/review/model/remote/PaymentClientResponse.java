package be.fooda.backend.review.model.remote;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentClientResponse {

    Long paymentId;
    String title;
    String method;
    BigDecimal amount;

}
