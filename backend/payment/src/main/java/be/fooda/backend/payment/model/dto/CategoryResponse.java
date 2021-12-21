package be.fooda.backend.payment.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryResponse implements Serializable {

    Long categoryId;
    String title;
    Byte[] icon;

    public CategoryResponse withCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public CategoryResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    public CategoryResponse withIcon(Byte[] icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryResponse)) return false;
        CategoryResponse that = (CategoryResponse) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
