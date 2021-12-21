package be.fooda.backend.product.model.entity;

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
@Entity(name = "products")
// HIBERNATE SEARCH
@Indexed
public class ProductEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    public ProductEntity withId(Long id) {
        this.id = id;
        return this;
    }

    Boolean isActive = Boolean.TRUE;

    public ProductEntity withActive(Boolean active) {
        isActive = active;
        return this;
    }

    @FullTextField
    String title;

    public ProductEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    @KeywordField
    @Column(unique = true)
    String eTrackingId;

    public ProductEntity witheTrackingId(String eTrackingId) {
        this.eTrackingId = eTrackingId;
        return this;
    }

    @Lob
    @FullTextField
    String description;

    public ProductEntity withDescription(String description) {
        this.description = description;
        return this;
    }

    @GenericField
    Integer limitPerOrder = 0;

    public ProductEntity withLimitPerOrder(Integer limitPerOrder) {
        this.limitPerOrder = limitPerOrder;
        return this;
    }

    Boolean isFeatured = Boolean.FALSE;

    public ProductEntity withFeatured(Boolean featured) {
        isFeatured = featured;
        return this;
    }

    Long storeId;

    public ProductEntity withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    @FullTextField
    @Enumerated(EnumType.STRING)
    TypeEntity type;

    public ProductEntity withType(TypeEntity type) {
        this.type = type;
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<PriceEntity> prices = new LinkedHashSet<>();

    public void setPrices(Set<PriceEntity> prices) {
        this.prices = prices;
        for (PriceEntity price : this.prices) {
            price.setProduct(this);
        }
    }

    public void addPrice(PriceEntity price) {
        price.setProduct(this);
        this.prices.add(price);
    }

    public void removePrice(PriceEntity price) {
        price.setProduct(this);
        this.prices.remove(price);
    }

    public ProductEntity withPrices(Set<PriceEntity> prices) {
        this.setPrices(prices);
        return this;
    }

    public ProductEntity withPrice(PriceEntity price) {
        this.addPrice(price);
        return this;
    }

    public ProductEntity withoutPrice(PriceEntity price) {
        this.removePrice(price);
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<TaxEntity> taxes = new LinkedHashSet<>();

    public void addTax(TaxEntity tax) {
        tax.setProduct(this);
        this.taxes.add(tax);
    }

    public void removeTax(TaxEntity tax) {
        tax.setProduct(this);
        this.taxes.remove(tax);
    }

    public void setTaxes(Set<TaxEntity> taxes) {
        this.taxes = taxes;
        for(TaxEntity tax : taxes){
            tax.setProduct(this);
        }
    }

    public ProductEntity withTaxes(Set<TaxEntity> taxes) {
        this.setTaxes(taxes);
        return this;
    }

    public ProductEntity withTax(TaxEntity tax) {
        this.addTax(tax);
        return this;
    }

    public ProductEntity withoutTax(TaxEntity tax) {
        this.removeTax(tax);
        return this;
    }

    Long defaultImageId;

    public ProductEntity withDefaultImageId(Long defaultImageId) {
        this.defaultImageId = defaultImageId;
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<CategoryEntity> categories = new LinkedHashSet<>();

    public void addCategory(CategoryEntity category) {
        category.setProduct(this);
        this.categories.add(category);
    }

    public void removeCategory(CategoryEntity category) {
        category.setProduct(this);
        this.categories.remove(category);
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
        for(CategoryEntity category : this.categories){
            category.setProduct(this);
        }
    }

    public ProductEntity withCategories(Set<CategoryEntity> categories) {
        this.setCategories(categories);
        return this;
    }

    public ProductEntity withCategory(CategoryEntity category) {
        this.addCategory(category);
        return this;
    }

    public ProductEntity withoutCategory(CategoryEntity category) {
        this.removeCategory(category);
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<TagEntity> tags = new LinkedHashSet<>();

    public void addTag(TagEntity tag) {
        tag.setProduct(this);
        this.tags.add(tag);
    }

    public void removeTag(TagEntity tag) {
        tag.setProduct(this);
        this.tags.remove(tag);
    }

    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
        for(TagEntity tag : tags){
            tag.setProduct(this);
        }
    }

    public ProductEntity withTags(Set<TagEntity> tags) {
        this.setTags(tags);
        return this;
    }

    public ProductEntity withTag(TagEntity tag) {
        this.addTag(tag);
        return this;
    }

    public ProductEntity withoutTag(TagEntity tag) {
        this.removeTag(tag);
        return this;
    }

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<IngredientEntity> ingredients = new LinkedHashSet<>();

    public void addIngredient(IngredientEntity ingredient) {
        ingredient.setProduct(this);
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(IngredientEntity ingredient) {
        ingredient.setProduct(this);
        this.ingredients.remove(ingredient);
    }

    public void setIngredients(Set<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
        for(IngredientEntity ingredient : ingredients){
            ingredient.setProduct(this);
        }
    }

    public ProductEntity withIngredients(Set<IngredientEntity> ingredients) {
        this.setIngredients(ingredients);
        return this;
    }

    public ProductEntity withIngredient(IngredientEntity ingredient) {
        this.addIngredient(ingredient);
        return this;
    }

    public ProductEntity withoutIngredient(IngredientEntity ingredient) {
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
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
