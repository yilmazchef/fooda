package be.fooda.backend.order.model.dto;

import be.fooda.backend.order.model.entity.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.math.BigDecimal;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"deliveryId"})
public class DeliveryResponse implements Serializable {

    Long deliveryId;
    BigDecimal cost;
    OrderStatus status = OrderStatus.ON_DELIVERY_PARENT;
}
