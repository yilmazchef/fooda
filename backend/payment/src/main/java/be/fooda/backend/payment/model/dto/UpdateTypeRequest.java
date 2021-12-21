package be.fooda.backend.payment.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum UpdateTypeRequest {

    SIMPLE("A payment which have no variations"),
    GROUPED("A payment which has variations"),
    COMPLEX("multiple payments in a payment");

    String value;

}
