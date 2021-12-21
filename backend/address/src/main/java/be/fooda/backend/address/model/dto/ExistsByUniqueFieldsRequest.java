package be.fooda.backend.address.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.util.Objects;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
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
