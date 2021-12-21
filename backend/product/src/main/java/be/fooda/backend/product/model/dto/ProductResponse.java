package be.fooda.backend.product.model.dto;

import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse implements Serializable {

    Long productId;
    Boolean isActive;
    String title;
    String eTrackingId;
    String description;
    Integer limitPerOrder;
    Boolean isFeatured;

    StoreResponse store;

    TypeResponse type;

    MediaResponse defaultImage;

    public ProductResponse withProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public ProductResponse withActive(Boolean active) {
        isActive = active;
        return this;
    }

    public ProductResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    public ProductResponse witheTrackingId(String eTrackingId) {
        this.eTrackingId = eTrackingId;
        return this;
    }

    public ProductResponse withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductResponse withLimitPerOrder(Integer limitPerOrder) {
        this.limitPerOrder = limitPerOrder;
        return this;
    }

    public ProductResponse withFeatured(Boolean featured) {
        isFeatured = featured;
        return this;
    }

    public ProductResponse withStore(StoreResponse store) {
        this.store = store;
        return this;
    }

    public ProductResponse withType(TypeResponse type) {
        this.type = type;
        return this;
    }

    public ProductResponse withDefaultImage(MediaResponse defaultImage) {
        this.defaultImage = defaultImage;
        return this;
    }

    private final Set<PriceResponse> prices = new LinkedHashSet<>();

    public void addPrice(PriceResponse price) {
        this.prices.add(price);
    }

    public void removePrice(PriceResponse price) {
        this.prices.remove(price);
    }

    private final Set<TaxResponse> taxes = new LinkedHashSet<>();

    public void addTax(TaxResponse tax){
        this.taxes.add(tax);
    }

    public void removeTax(TaxResponse tax){
        this.taxes.remove(tax);
    }

    private final Set<CategoryResponse> categories = new LinkedHashSet<>();

    public void addCategory(CategoryResponse category){
        this.categories.add(category);
    }

    public void removeCategory(CategoryResponse category){
        this.categories.remove(category);
    }

    private final Set<TagResponse> tags = new LinkedHashSet<>();

    public void addTag(TagResponse tag){
        this.tags.add(tag);
    }

    public void removeTag(TagResponse tag){
        this.tags.remove(tag);
    }

    private final Set<IngredientResponse> ingredients = new LinkedHashSet<>();

    public void addIngredient(IngredientResponse ingredient){
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(IngredientResponse ingredient){
        this.ingredients.remove(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductResponse)) return false;
        ProductResponse that = (ProductResponse) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getStore(), that.getStore()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getStore(), getType());
    }
}
