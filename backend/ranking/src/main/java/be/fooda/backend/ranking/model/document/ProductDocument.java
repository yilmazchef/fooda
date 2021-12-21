package be.fooda.backend.ranking.model.document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(of = {"productId"})
@Document
public class ProductDocument {

    @Id
    String id;

    @Min(1)
    @Max(10)
    Integer ranking;

    Long productId;

    String session;

    Double quantity;

    BigDecimal price;

    BigDecimal discount;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

    Boolean active;

    public ProductDocument withId(String id) {
        this.id = id;
        return this;
    }

    public ProductDocument withRanking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public ProductDocument withProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public ProductDocument withSession(String session) {
        this.session = session;
        return this;
    }

    public ProductDocument withQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductDocument withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductDocument withDiscount(BigDecimal discount) {
        this.discount = discount;
        return this;
    }

    public ProductDocument withActive(Boolean active) {
        this.active = active;
        return this;
    }
}
