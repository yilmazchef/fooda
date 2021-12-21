package be.fooda.backend.payment.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JPA
@Entity(name = "payments")
// HIBERNATE SEARCH
@Indexed
public class PaymentEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    public PaymentEntity withId(Long id) {
        this.id = id;
        return this;
    }

    Boolean isActive = Boolean.TRUE;

    public PaymentEntity withActive(Boolean active) {
        isActive = active;
        return this;
    }

    @FullTextField
    String title;

    public PaymentEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    @KeywordField
    @Column(unique = true)
    String eTrackingId;

    public PaymentEntity witheTrackingId(String eTrackingId) {
        this.eTrackingId = eTrackingId;
        return this;
    }

    @Lob
    @FullTextField
    String description;

    public PaymentEntity withDescription(String description) {
        this.description = description;
        return this;
    }

    @GenericField
    Integer limitPerOrder = 0;

    public PaymentEntity withLimitPerOrder(Integer limitPerOrder) {
        this.limitPerOrder = limitPerOrder;
        return this;
    }

    Boolean isFeatured = Boolean.FALSE;

    public PaymentEntity withFeatured(Boolean featured) {
        isFeatured = featured;
        return this;
    }

    Long storeId;

    public PaymentEntity withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    @FullTextField
    @Enumerated(EnumType.STRING)
    TypeEntity type;

    public PaymentEntity withType(TypeEntity type) {
        this.type = type;
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<PriceEntity> prices = new LinkedHashSet<>();

    public void setPrices(Set<PriceEntity> prices) {
        this.prices = prices;
        for (PriceEntity price : this.prices) {
            price.setPayment(this);
        }
    }

    public void addPrice(PriceEntity price) {
        price.setPayment(this);
        this.prices.add(price);
    }

    public void removePrice(PriceEntity price) {
        price.setPayment(this);
        this.prices.remove(price);
    }

    public PaymentEntity withPrices(Set<PriceEntity> prices) {
        this.setPrices(prices);
        return this;
    }

    public PaymentEntity withPrice(PriceEntity price) {
        this.addPrice(price);
        return this;
    }

    public PaymentEntity withoutPrice(PriceEntity price) {
        this.removePrice(price);
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<TaxEntity> taxes = new LinkedHashSet<>();

    public void addTax(TaxEntity tax) {
        tax.setPayment(this);
        this.taxes.add(tax);
    }

    public void removeTax(TaxEntity tax) {
        tax.setPayment(this);
        this.taxes.remove(tax);
    }

    public void setTaxes(Set<TaxEntity> taxes) {
        this.taxes = taxes;
        for(TaxEntity tax : taxes){
            tax.setPayment(this);
        }
    }

    public PaymentEntity withTaxes(Set<TaxEntity> taxes) {
        this.setTaxes(taxes);
        return this;
    }

    public PaymentEntity withTax(TaxEntity tax) {
        this.addTax(tax);
        return this;
    }

    public PaymentEntity withoutTax(TaxEntity tax) {
        this.removeTax(tax);
        return this;
    }

    Long defaultImageId;

    public PaymentEntity withDefaultImageId(Long defaultImageId) {
        this.defaultImageId = defaultImageId;
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<CategoryEntity> categories = new LinkedHashSet<>();

    public void addCategory(CategoryEntity category) {
        category.setPayment(this);
        this.categories.add(category);
    }

    public void removeCategory(CategoryEntity category) {
        category.setPayment(this);
        this.categories.remove(category);
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
        for(CategoryEntity category : this.categories){
            category.setPayment(this);
        }
    }

    public PaymentEntity withCategories(Set<CategoryEntity> categories) {
        this.setCategories(categories);
        return this;
    }

    public PaymentEntity withCategory(CategoryEntity category) {
        this.addCategory(category);
        return this;
    }

    public PaymentEntity withoutCategory(CategoryEntity category) {
        this.removeCategory(category);
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<TagEntity> tags = new LinkedHashSet<>();

    public void addTag(TagEntity tag) {
        tag.setPayment(this);
        this.tags.add(tag);
    }

    public void removeTag(TagEntity tag) {
        tag.setPayment(this);
        this.tags.remove(tag);
    }

    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
        for(TagEntity tag : tags){
            tag.setPayment(this);
        }
    }

    public PaymentEntity withTags(Set<TagEntity> tags) {
        this.setTags(tags);
        return this;
    }

    public PaymentEntity withTag(TagEntity tag) {
        this.addTag(tag);
        return this;
    }

    public PaymentEntity withoutTag(TagEntity tag) {
        this.removeTag(tag);
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<IngredientEntity> ingredients = new LinkedHashSet<>();

    public void addIngredient(IngredientEntity ingredient) {
        ingredient.setPayment(this);
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(IngredientEntity ingredient) {
        ingredient.setPayment(this);
        this.ingredients.remove(ingredient);
    }

    public void setIngredients(Set<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
        for(IngredientEntity ingredient : ingredients){
            ingredient.setPayment(this);
        }
    }

    public PaymentEntity withIngredients(Set<IngredientEntity> ingredients) {
        this.setIngredients(ingredients);
        return this;
    }

    public PaymentEntity withIngredient(IngredientEntity ingredient) {
        this.addIngredient(ingredient);
        return this;
    }

    public PaymentEntity withoutIngredient(IngredientEntity ingredient) {
        this.removeIngredient(ingredient);
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
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
