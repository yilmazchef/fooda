package be.fooda.backend.payment.model.dto;

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
public class CreateTaxRequest implements Serializable{

    String title;
    Double percentage;
    Boolean isDefault;

    public CreateTaxRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateTaxRequest withPercentage(Double percentage) {
        this.percentage = percentage;
        return this;
    }

    public CreateTaxRequest withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateTaxRequest)) return false;
        CreateTaxRequest that = (CreateTaxRequest) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
