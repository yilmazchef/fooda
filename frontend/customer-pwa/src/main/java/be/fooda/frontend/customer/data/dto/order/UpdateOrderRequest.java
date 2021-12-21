package be.fooda.frontend.customer.data.dto.order;

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
@EqualsAndHashCode(of = {"trackingId"})
public class UpdateOrderRequest implements Serializable {

    String trackingId;
    Boolean isActive;
    Long deliveryId;
    Long customerId;
    Long storeId;
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
    Set<Long> products = new LinkedHashSet<>();
    Set<Long> payments = new LinkedHashSet<>();

    public void addProduct(Long productId) {
        this.products.add(productId);
    }

    public void removeProduct(Long productId) {
        this.products.remove(productId);
    }

    public void addPayment(Long paymentId) {
        this.payments.add(paymentId);
    }

    public void removePayment(Long paymentId) {
        this.payments.remove(paymentId);
    }

    public BigDecimal getDiscount() {
        return BigDecimal.ZERO;
    }
}
