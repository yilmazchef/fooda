package be.fooda.backend.order.model.dto;

import be.fooda.backend.order.model.entity.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"id"})
public class OrderResponse implements Serializable {

    Long id;
    String trackingId;
    Boolean isActive;
    DeliveryResponse delivery;
    CustomerResponse customer;
    StoreResponse store;
    OrderStatus status;
    String note;
    Timestamp requiredAt;
    Timestamp createdAt;
    Timestamp updatedAt;
    Timestamp deliveredAt;
    Timestamp paymentAt;
    BigDecimal productsTotal;
    BigDecimal taxTotal;
    BigDecimal deliveryTotal;
    BigDecimal priceTotal;
    Set<ProductResponse> products = new LinkedHashSet<>();
    Set<PaymentResponse> payments = new LinkedHashSet<>();

}
