package be.fooda.backend.product.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
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
@Entity(name = "taxes")
public class TaxEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    public TaxEntity withId(Long id) {
        this.id = id;
        return this;
    }

    @Column(nullable = false, unique = true)
    @FullTextField
    String title;

    public TaxEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    @GenericField
    Double percentage = 0.00;

    public TaxEntity withPercentage(Double percentage) {
        this.percentage = percentage;
        return this;
    }

    Boolean isDefault = Boolean.FALSE;

    public TaxEntity withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    @ToString.Exclude
    @JoinColumn(name = "product_id")
    @ManyToOne
    ProductEntity product;

    public TaxEntity withProduct(Long productId) {
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
        TaxEntity taxEntity = (TaxEntity) o;
        return Objects.equals(id, taxEntity.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
