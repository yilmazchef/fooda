package be.fooda.backend.delivery.model.entity;


import be.fooda.backend.delivery.model.DeliveryStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "id" })
@Slf4j
// JPA
@Entity(name = "deliveries")

// HIBERNATE SEARCH
@Indexed
public class DeliveryEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String trackingId;

    Long orderId;

    Long storeId;

    Long customerId;

    Long courierId;

    String createdAt;

    String updatedAt;

    String requestedAt;

    String deliveredAt;

    Double duration;

    Boolean active;

    @Enumerated(EnumType.STRING)
    DeliveryStatus status;

    @Lob
    @FullTextField
    String note;

    @Override
    public boolean isNew() {
        return Objects.isNull(id);}


    @PrePersist
    private void prePersistFunction() {
        log.info("PrePersist method called. Auto-persistable fields are being managed.");
        this.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
        this.setActive(true);
    }

    @PreUpdate
    public void preUpdateFunction() {
        log.info("PreUpdate method called. Auto-updatable fields are being managed.");
        this.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
    }


    /*
    Event based
    JavaMailSender
    Spring Mail
    Mail can be an apart module
    Mail content type (text, html ...)

    endpoints:
    Courier
    Store
    Customer
    Order

     */
}
