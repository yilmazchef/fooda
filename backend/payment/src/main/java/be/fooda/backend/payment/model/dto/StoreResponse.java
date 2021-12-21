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
public class StoreResponse {

    Long storeId;

    String title;

    public StoreResponse withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public StoreResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreResponse)) return false;
        StoreResponse that = (StoreResponse) o;
        return Objects.equals(getStoreId(), that.getStoreId()) && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStoreId(), getTitle());
    }
}
