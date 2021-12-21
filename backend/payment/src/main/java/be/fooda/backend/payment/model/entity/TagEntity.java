package be.fooda.backend.payment.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JPA
@Entity(name = "tags")
public class TagEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    public TagEntity withId(Long id) {
        this.id = id;
        return this;
    }

    @FullTextField
    @Column(nullable = false, unique = false)
    String value;

    public TagEntity withValue(String value) {
        this.value = value;
        return this;
    }

    @ToString.Exclude
    @JoinColumn(name = "payment_id")
    @ManyToOne
    PaymentEntity payment;

    public TagEntity withPayment(Long paymentId) {
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
        TagEntity tagEntity = (TagEntity) o;
        return Objects.equals(id, tagEntity.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
