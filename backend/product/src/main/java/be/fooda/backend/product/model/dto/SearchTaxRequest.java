package be.fooda.backend.product.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.*;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchTaxRequest implements Serializable{

    String title;
    Double percentage;

    public SearchTaxRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchTaxRequest)) return false;
        SearchTaxRequest that = (SearchTaxRequest) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    public SearchTaxRequest withPercentage(Double percentage) {
        this.percentage = percentage;
        return this;
    }
}
