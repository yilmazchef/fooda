package be.fooda.backend.payment.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExistsByUniqueFieldsRequest {

    String title;

    Long storeId;

    public ExistsByUniqueFieldsRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public ExistsByUniqueFieldsRequest withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExistsByUniqueFieldsRequest)) return false;
        ExistsByUniqueFieldsRequest that = (ExistsByUniqueFieldsRequest) o;
        return Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getStoreId(), that.getStoreId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getStoreId());
    }
}
