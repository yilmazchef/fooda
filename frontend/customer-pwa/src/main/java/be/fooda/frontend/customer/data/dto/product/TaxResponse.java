package be.fooda.frontend.customer.data.dto.product;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "taxId" })

// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)

public class TaxResponse implements Serializable{

    Long taxId;
    String title;
    Double percentage;
    Boolean isDefault;


    public TaxResponse withTaxId(Long taxId) {
        setTaxId(taxId);
        return this;
    }

    public TaxResponse withTitle(String title) {
        setTitle(title);
        return this;
    }

    public TaxResponse withPercentage(Double percentage) {
        setPercentage(percentage);
        return this;
    }

    public TaxResponse withIsDefault(Boolean isDefault) {
        setIsDefault(isDefault);
        return this;
    }


}
