package be.fooda.frontend.customer.data.dto.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@Jacksonized
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaExistenceRequest implements Serializable {

    Long userId;

    Long relatedId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof MediaExistenceRequest)) return false;

        MediaExistenceRequest that = (MediaExistenceRequest) o;

        return new EqualsBuilder().append(getUserId(), that.getUserId()).append(getRelatedId(), that.getRelatedId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getUserId()).append(getRelatedId()).toHashCode();
    }
}
