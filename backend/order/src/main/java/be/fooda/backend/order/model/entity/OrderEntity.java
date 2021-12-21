package be.fooda.backend.order.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "id" })

// JPA
@Entity(name = "orders")

// HIBERNATE SEARCH
@Indexed

public class OrderEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    public OrderEntity withId(Long id) {
        this.setId(id);
        return this;
    }

    public OrderEntity withNewId() {
        this.setId(null);
        return this;
    }

    // TODO add endpoint
    String trackingId;

    Boolean isActive = Boolean.TRUE;

    Long deliveryId;

    // TODO add endpoint
    Long customerId;

    // TODO add endpoint
    Long storeId;

    @Enumerated(EnumType.STRING)
    OrderStatus status = OrderStatus.WAITING_FOR_CONFIRMATION;

    public OrderEntity withStatus(OrderStatus status) {
        this.setStatus(status);
        return this;
    }

    public OrderEntity withDefaultStatus() {
        this.setStatus(OrderStatus.PROCESSING);
        return this;
    }

    @Lob
    @FullTextField
    String note;

    Timestamp requiredAt;

    Timestamp createdAt;

    Timestamp updatedAt;

    Timestamp deliveredAt;

    Timestamp paymentAt;

    @Min(value = 0)
    BigDecimal productsTotal;

    @Min(value = 0)
    BigDecimal taxTotal;

    @Min(value = 0)
    BigDecimal deliveryTotal;

    @Min(value = 0)
    BigDecimal priceTotal;

    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_id")
    Set<Long> products = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "order_payments", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "payment_id")
    Set<Long> payments = new LinkedHashSet<>();

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    public void addProduct(Long productId){
        products.add(productId);
    }

    public void removeProduct(Long productId){
        products.remove(productId);
    }

    public void addPayment(Long paymentId){
        payments.add(paymentId);
    }

    public void removePayment(Long paymentId){
        payments.remove(paymentId);
    }

    @PrePersist
    public void prePersist() {
        this.setCreatedAt(Timestamp.from(Instant.now()));
        if(this.getRequiredAt() == null){
            this.setCreatedAt(Timestamp.from(Instant.now().plusSeconds(60 * 60 * 1)));
        }
    }

    @PreRemove
    public void preRemove() {
    }
    @PreUpdate
    public void preUpdate() {
    }
    @PostUpdate
    public void postUpdate() {
    }
    @PostPersist
    public void postPersist() {
    }
    @PostRemove
    public void postRemove() {
    }
}
