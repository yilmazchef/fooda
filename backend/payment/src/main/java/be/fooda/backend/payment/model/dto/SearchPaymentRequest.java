package be.fooda.backend.payment.model.dto;

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
public class SearchPaymentRequest implements Serializable{

    Boolean isActive;
    String title;
    String eTrackingId;
    String description;
    Integer limitPerOrder;
    Boolean isFeatured;
    Long storeId;
    SearchTypeRequest type;
    Long defaultImageId;


    public SearchPaymentRequest withActive(Boolean active) {
        isActive = active;
        return this;
    }

    public SearchPaymentRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public SearchPaymentRequest witheTrackingId(String eTrackingId) {
        this.eTrackingId = eTrackingId;
        return this;
    }

    public SearchPaymentRequest withDescription(String description) {
        this.description = description;
        return this;
    }

    public SearchPaymentRequest withLimitPerOrder(Integer limitPerOrder) {
        this.limitPerOrder = limitPerOrder;
        return this;
    }

    public SearchPaymentRequest withFeatured(Boolean featured) {
        isFeatured = featured;
        return this;
    }

    public SearchPaymentRequest withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public SearchPaymentRequest withType(SearchTypeRequest type) {
        this.type = type;
        return this;
    }

    public SearchPaymentRequest withDefaultImageId(Long defaultImageId) {
        this.defaultImageId = defaultImageId;
        return this;
    }
    private final Set<SearchPriceRequest> prices = new LinkedHashSet<>();


    public void addPrice(SearchPriceRequest price){
        this.prices.add(price);
    }

    public void removePrice(SearchPriceRequest price){
        this.prices.remove(price);
    }
    private final Set<SearchTaxRequest> taxes = new LinkedHashSet<>();


    public void addTax(SearchTaxRequest tax){
        this.taxes.add(tax);
    }

    public void removeTax(SearchTaxRequest tax){
        this.taxes.remove(tax);
    }

    private final Set<SearchCategoryRequest> categories = new LinkedHashSet<>();

    public void addCategory(SearchCategoryRequest category){
        this.categories.add(category);
    }

    public void removeCategory(SearchCategoryRequest category){
        this.categories.remove(category);
    }

    private final Set<SearchTagRequest> tags = new LinkedHashSet<>();

    public void addTag(SearchTagRequest tag){
        this.tags.add(tag);
    }

    public void removeTag(SearchTagRequest tag){
        this.tags.remove(tag);
    }

    private final Set<SearchIngredientRequest> ingredients = new LinkedHashSet<>();

    public void addIngredient(SearchIngredientRequest ingredient){
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(SearchIngredientRequest ingredient){
        this.ingredients.remove(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchPaymentRequest)) return false;
        SearchPaymentRequest that = (SearchPaymentRequest) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getStoreId(), that.getStoreId()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getStoreId(), getType());
    }
}
