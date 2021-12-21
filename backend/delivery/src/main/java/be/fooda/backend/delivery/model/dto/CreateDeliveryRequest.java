package be.fooda.backend.delivery.model.dto;


import be.fooda.backend.delivery.model.DeliveryStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "orderId","customerId"})
public class CreateDeliveryRequest {

    String trackingId;

    Long orderId;

    Long storeId;

    Long customerId;

    Long courierId;

    String requestedAt;

    String deliveredAt;

    DeliveryStatus status;

    String note;
}
