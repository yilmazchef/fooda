package be.fooda.backend.payment.model.dto;

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
public class UpdateTaxRequest implements Serializable{

    String title;
    Double percentage;
    Boolean isDefault;

    public UpdateTaxRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public UpdateTaxRequest withPercentage(Double percentage) {
        this.percentage = percentage;
        return this;
    }

    public UpdateTaxRequest withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateTaxRequest)) return false;
        UpdateTaxRequest that = (UpdateTaxRequest) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
