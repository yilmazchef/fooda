package be.fooda.backend.product.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class CreateCategoryRequest implements Serializable{

    String title;
    Byte[] icon;

    public CreateCategoryRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateCategoryRequest withIcon(Byte[] icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateCategoryRequest)) return false;
        CreateCategoryRequest that = (CreateCategoryRequest) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
