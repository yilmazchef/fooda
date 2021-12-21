package be.fooda.frontend.customer.data.dto.product;


import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "tagId" })

// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)

public class TagResponse implements Serializable{

    Long tagId;
    String value;


    public TagResponse withTagId(Long tagId) {
        setTagId(tagId);
        return this;
    }

    public TagResponse withValue(String value) {
        setValue(value);
        return this;
    }


}
