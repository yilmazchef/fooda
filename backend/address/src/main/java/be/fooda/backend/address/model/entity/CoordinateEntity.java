package be.fooda.backend.address.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// JPA
@Embeddable
public class CoordinateEntity {

    Double latitude;

    Double longitude;

    public CoordinateEntity withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public CoordinateEntity withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinateEntity)) return false;
        CoordinateEntity that = (CoordinateEntity) o;
        return getLatitude().equals(that.getLatitude()) && getLongitude().equals(that.getLongitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLatitude(), getLongitude());
    }
}