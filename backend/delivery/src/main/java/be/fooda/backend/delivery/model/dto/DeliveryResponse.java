package be.fooda.backend.delivery.model.dto;


import be.fooda.backend.delivery.model.DeliveryStatus;
import be.fooda.backend.delivery.model.remote.CustomerClientResponse;
import be.fooda.backend.delivery.model.remote.OrderClientResponse;
import be.fooda.backend.delivery.model.remote.StoreClientResponse;
import be.fooda.backend.delivery.view.client.CourierClient;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "id" })

public class DeliveryResponse {

    Long id;

    String trackingId;

    StoreClientResponse store;

    OrderClientResponse order;

    CustomerClientResponse customer;

    CourierClient courier;

    DeliveryStatus status;

    String note;
}
