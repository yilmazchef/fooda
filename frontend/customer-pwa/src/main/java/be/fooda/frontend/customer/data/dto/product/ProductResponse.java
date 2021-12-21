package be.fooda.frontend.customer.data.dto.product;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "productId" })

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

    MediaResponse defaultImage;

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

    public ProductResponse withProductId(Long productId) {
        setProductId(productId);
        return this;
    }

    public ProductResponse withIsActive(Boolean isActive) {
        setIsActive(isActive);
        return this;
    }

    public ProductResponse withTitle(String title) {
        setTitle(title);
        return this;
    }

    public ProductResponse withETrackingId(String eTrackingId) {
        setETrackingId(eTrackingId);
        return this;
    }

    public ProductResponse withDescription(String description) {
        setDescription(description);
        return this;
    }

    public ProductResponse withLimitPerOrder(Integer limitPerOrder) {
        setLimitPerOrder(limitPerOrder);
        return this;
    }

    public ProductResponse withIsFeatured(Boolean isFeatured) {
        setIsFeatured(isFeatured);
        return this;
    }

    public ProductResponse withStore(StoreResponse store) {
        setStore(store);
        return this;
    }

    public ProductResponse withType(TypeResponse type) {
        setType(type);
        return this;
    }

    public ProductResponse withDefaultImage(MediaResponse defaultImage) {
        setDefaultImage(defaultImage);
        return this;
    }


}
