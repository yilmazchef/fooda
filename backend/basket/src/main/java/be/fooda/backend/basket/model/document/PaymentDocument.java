package be.fooda.backend.basket.model.document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
public class PaymentDocument {

    Long paymentId;
    BigDecimal amount;
    Boolean isPaid;

    Boolean active;
}
