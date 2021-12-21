package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {

    Long id;
    Long orderId;
    String note;

    public OrderResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public OrderResponse withOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderResponse withNote(String note) {
        this.note = note;
        return this;
    }
}