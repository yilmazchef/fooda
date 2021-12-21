package be.fooda.backend.payment.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JPA
@Entity(name = "ingredients")
public class IngredientEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    public IngredientEntity withId(Long id) {
        this.id = id;
        return this;
    }

    @FullTextField
    String title;

    public IngredientEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    @GenericField
    BigDecimal price = BigDecimal.valueOf(0.0);

    public IngredientEntity withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @ToString.Exclude
    @JoinColumn(name = "payment_id")
    @ManyToOne
    PaymentEntity payment;

    public IngredientEntity withPaymentId(Long paymentId){
        this.payment.setId(paymentId);
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
        IngredientEntity that = (IngredientEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
