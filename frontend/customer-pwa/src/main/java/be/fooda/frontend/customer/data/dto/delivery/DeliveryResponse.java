package be.fooda.frontend.customer.data.dto.delivery;


import be.fooda.frontend.customer.data.dto.delivery.remote.CourierClientResponse;
import be.fooda.frontend.customer.data.dto.delivery.remote.CustomerClientResponse;
import be.fooda.frontend.customer.data.dto.delivery.remote.OrderClientResponse;
import be.fooda.frontend.customer.data.dto.delivery.remote.StoreClientResponse;
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

    CourierClientResponse courier;

    DeliveryStatus status;

    String note;
}
