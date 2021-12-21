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
public class CreateProductRequest implements Serializable{

    String title;

    String eTrackingId;

    String description;

    Integer limitPerOrder = 0;

    Boolean isFeatured = Boolean.FALSE;

    Long storeId;

    CreateTypeRequest type;

    public CreateProductRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateProductRequest witheTrackingId(String eTrackingId) {
        this.eTrackingId = eTrackingId;
        return this;
    }

    public CreateProductRequest withDescription(String description) {
        this.description = description;
        return this;
    }

    public CreateProductRequest withLimitPerOrder(Integer limitPerOrder) {
        this.limitPerOrder = limitPerOrder;
        return this;
    }

    public CreateProductRequest withFeatured(Boolean featured) {
        isFeatured = featured;
        return this;
    }

    public CreateProductRequest withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public CreateProductRequest withType(CreateTypeRequest type) {
        this.type = type;
        return this;
    }

    public CreateProductRequest withDefaultImageId(Long defaultImageId) {
        this.defaultImageId = defaultImageId;
        return this;
    }

    private final Set<CreatePriceRequest> prices = new LinkedHashSet<>();

    public void addPrice(CreatePriceRequest price){
        this.prices.add(price);
    }

    public void removePrice(CreatePriceRequest price){
        this.prices.remove(price);
    }

    private final Set<CreateTaxRequest> taxes = new LinkedHashSet<>();

    public void addTax(CreateTaxRequest tax){
        this.taxes.add(tax);
    }

    public void removeTax(CreateTaxRequest tax){
        this.taxes.remove(tax);
    }

    Long defaultImageId;

    private final Set<CreateCategoryRequest> categories = new LinkedHashSet<>();

    public void addCategory(CreateCategoryRequest category){
        this.categories.add(category);
    }

    public void removeCategory(CreateCategoryRequest category){
        this.categories.remove(category);
    }

    private final Set<CreateTagRequest> tags = new LinkedHashSet<>();

    public void addTag(CreateTagRequest tag){
        this.tags.add(tag);
    }

    public void removeTag(CreateTagRequest tag){
        this.tags.remove(tag);
    }

    private final Set<CreateIngredientRequest> ingredients = new LinkedHashSet<>();

    public void addIngredient(CreateIngredientRequest ingredient){
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(CreateIngredientRequest ingredient){
        this.ingredients.remove(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateProductRequest)) return false;
        CreateProductRequest that = (CreateProductRequest) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getStoreId(), that.getStoreId()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getStoreId(), getType());
    }
}
