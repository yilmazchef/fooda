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
public class TaxResponse implements Serializable{

    Long taxId;
    String title;
    Double percentage;
    Boolean isDefault;

    public TaxResponse withTaxId(Long taxId) {
        this.taxId = taxId;
        return this;
    }

    public TaxResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    public TaxResponse withPercentage(Double percentage) {
        this.percentage = percentage;
        return this;
    }

    public TaxResponse withDefault(Boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaxResponse)) return false;
        TaxResponse that = (TaxResponse) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
