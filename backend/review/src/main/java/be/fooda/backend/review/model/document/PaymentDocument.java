package be.fooda.backend.review.model.document;

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
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
public class PaymentDocument {

    @Id
    String id;

    String review;

    Long paymentId;

    String session;

    BigDecimal amount;

    Boolean isPaid;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

    Boolean active;

    public PaymentDocument withId(String id) {
        this.id = id;
        return this;
    }

    public PaymentDocument withReview(String review) {
        this.review = review;
        return this;
    }

    public PaymentDocument withPaymentId(Long paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public PaymentDocument withSession(String session) {
        this.session = session;
        return this;
    }

    public PaymentDocument withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public PaymentDocument withPaid(Boolean paid) {
        isPaid = paid;
        return this;
    }

    public PaymentDocument withActive(Boolean active) {
        this.active = active;
        return this;
    }
}
