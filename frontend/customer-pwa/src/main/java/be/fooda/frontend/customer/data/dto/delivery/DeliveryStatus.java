package be.fooda.frontend.customer.data.dto.delivery;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DeliveryStatus {
    ON_DELIVERY_PARENT,
    ON_DELIVERY_BEING_PREPARED,
    ON_DELIVERY_COURIER,
    ON_DELIVERY_ARRIVED,
    ON_DELIVERY_ADDRESS_VERIFY,
    ON_DELIVERY_SUCCESS;
}
