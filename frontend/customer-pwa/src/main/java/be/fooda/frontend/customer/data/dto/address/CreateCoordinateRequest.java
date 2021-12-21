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

public class CreateCoordinateRequest {

    Long id;
    Double latitude;
    Double longitude;

    public CreateCoordinateRequest withId(Long id) {
        this.id = id;
        return this;
    }

    public CreateCoordinateRequest withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public CreateCoordinateRequest withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateCoordinateRequest)) return false;
        CreateCoordinateRequest that = (CreateCoordinateRequest) o;
        return getLatitude().equals(that.getLatitude()) && getLongitude().equals(that.getLongitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLatitude(), getLongitude());
    }
}
