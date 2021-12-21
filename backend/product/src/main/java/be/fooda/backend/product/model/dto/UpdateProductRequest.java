package be.fooda.backend.product.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateProductRequest implements Serializable {

    String title;
    String eTrackingId;
    String description;
    Integer limitPerOrder;
    Boolean isFeatured;
    Long storeId;
    UpdateTypeRequest type;
    Long defaultImageId;

    public UpdateProductRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public UpdateProductRequest witheTrackingId(String eTrackingId) {
        this.eTrackingId = eTrackingId;
        return this;
    }

    public UpdateProductRequest withDescription(String description) {
        this.description = description;
        return this;
    }

    public UpdateProductRequest withLimitPerOrder(Integer limitPerOrder) {
        this.limitPerOrder = limitPerOrder;
        return this;
    }

    public UpdateProductRequest withFeatured(Boolean featured) {
        isFeatured = featured;
        return this;
    }

    public UpdateProductRequest withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public UpdateProductRequest withType(UpdateTypeRequest type) {
        this.type = type;
        return this;
    }

    public UpdateProductRequest withDefaultImageId(Long defaultImageId) {
        this.defaultImageId = defaultImageId;
        return this;
    }

    private final Set<UpdatePriceRequest> prices = new LinkedHashSet<>();

    public void addPrice(UpdatePriceRequest price) {
        this.prices.add(price);
    }

    public void removePrice(UpdatePriceRequest price) {
        this.prices.remove(price);
    }

    private final Set<UpdateTaxRequest> taxes = new LinkedHashSet<>();

    public void addTax(UpdateTaxRequest tax) {
        this.taxes.add(tax);
    }

    public void removeTax(UpdateTaxRequest tax) {
        this.taxes.remove(tax);
    }

    private final Set<UpdateCategoryRequest> categories = new LinkedHashSet<>();

    public void addCategories(UpdateCategoryRequest category){
        this.categories.add(category);
    }

    public void removeCategories(UpdateCategoryRequest category){
        this.categories.remove(category);
    }

    private final Set<UpdateTagRequest> tags = new LinkedHashSet<>();

    public void addTag(UpdateTagRequest tag){
        this.tags.add(tag);
    }

    public void removeTag(UpdateTagRequest tag){
        this.tags.remove(tag);
    }

    private final Set<UpdateIngredientRequest> ingredients = new LinkedHashSet<>();

    public void addIngredient(UpdateIngredientRequest ingredient){
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(UpdateIngredientRequest ingredient){
        this.ingredients.remove(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateProductRequest)) return false;
        UpdateProductRequest that = (UpdateProductRequest) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getStoreId(), that.getStoreId()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getStoreId(), getType());
    }
}
