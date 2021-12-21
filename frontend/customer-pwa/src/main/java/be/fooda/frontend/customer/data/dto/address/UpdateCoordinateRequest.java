package be.fooda.frontend.customer.data.dto.address;

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

public class UpdateCoordinateRequest {

    Long id;
    Double latitude;
    Double longitude;

    public UpdateCoordinateRequest withId(Long id) {
        this.id = id;
        return this;
    }

    public UpdateCoordinateRequest withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public UpdateCoordinateRequest withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateCoordinateRequest)) return false;
        UpdateCoordinateRequest that = (UpdateCoordinateRequest) o;
        return getLatitude().equals(that.getLatitude()) && getLongitude().equals(that.getLongitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLatitude(), getLongitude());
    }
}
