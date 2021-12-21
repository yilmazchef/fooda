package be.fooda.backend.ranking.model.document;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(value = "customer_document")
public class CustomerDocument {

    @Id
    String id;

    @Min(1)
    @Max(10)
    Integer ranking;

    Long userId;

    String session;

    Long customerId;

    Long billingAddressId;

    Long deliveryAddressId;

    Long billingContactId;

    Long deliveryContactId;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

    Boolean active;

    public CustomerDocument withId(String id) {
        this.id = id;
        return this;
    }

    public CustomerDocument withRanking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public CustomerDocument withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public CustomerDocument withSession(String session) {
        this.session = session;
        return this;
    }

    public CustomerDocument withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public CustomerDocument withBillingAddressId(Long billingAddressId) {
        this.billingAddressId = billingAddressId;
        return this;
    }

    public CustomerDocument withDeliveryAddressId(Long deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
        return this;
    }

    public CustomerDocument withBillingContactId(Long billingContactId) {
        this.billingContactId = billingContactId;
        return this;
    }

    public CustomerDocument withDeliveryContactId(Long deliveryContactId) {
        this.deliveryContactId = deliveryContactId;
        return this;
    }

    public CustomerDocument withActive(Boolean active) {
        this.active = active;
        return this;
    }
}
