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
@Entity(name = "categories")
public class CategoryEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    public CategoryEntity withId(Long id) {
        this.id = id;
        return this;
    }

    @FullTextField
    @Column(nullable = false)
    String title;

    public CategoryEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    @Lob
    Byte[] icon;

    public CategoryEntity withIcon(Byte[] icon) {
        this.icon = icon;
        return this;
    }

    @ToString.Exclude
    @JoinColumn(name = "payment_id")
    @ManyToOne
    PaymentEntity payment;

    public CategoryEntity withPaymentId(Long paymentId) {
        this.payment.setId(paymentId);
        return this;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
