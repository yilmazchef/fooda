package be.fooda.frontend.customer.data.dto.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExistsByUniqueFieldsRequest {

    String title;

    Long userId;

    public ExistsByUniqueFieldsRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public ExistsByUniqueFieldsRequest withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExistsByUniqueFieldsRequest)) return false;
        ExistsByUniqueFieldsRequest that = (ExistsByUniqueFieldsRequest) o;
        return getTitle().equals(that.getTitle()) && getUserId().equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getUserId());
    }
}
