package be.fooda.backend.product.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JPA
@Entity(name = "prices")
public class PriceEntity implements Serializable, Persistable<Long>  {

    @Id
    @GeneratedValue
    Long id;

    public PriceEntity withId(Long id) {
        this.id = id;
        return this;
    }

    @FullTextField
    String title;

    public PriceEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    @GenericField
    @PositiveOrZero
    BigDecimal amount = BigDecimal.ZERO;

    public PriceEntity withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    @GenericField
    @FutureOrPresent
    LocalDateTime expiresAt;

    public PriceEntity withExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    Boolean isDefault = Boolean.FALSE;

    public PriceEntity withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    @FullTextField
    String currency = "EUR"; // EURO, €, EUR -> EUR

    public PriceEntity withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @ToString.Exclude
    @JoinColumn(name = "product_id")
    @ManyToOne
    ProductEntity product;

    public PriceEntity withProductId(Long productId) {
        this.product.setId(productId);
        return this;
    }

    @Override
    public boolean isNew() {
        return Objects.isNull(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PriceEntity that = (PriceEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
