package be.fooda.backend.courier.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleResponse implements Serializable {

    Long vehicleId;

    public VehicleResponse withVehicleId(Long id) {
        this.vehicleId = id;
        return this;
    }

    String title;

    public VehicleResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    Set<Long> photos = new LinkedHashSet<>();

    public void addPhoto(Long mediaId) {
        this.photos.add(mediaId);
    }

    public void removePhoto(Long mediaId) {
        this.photos.remove(mediaId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleResponse)) return false;
        VehicleResponse that = (VehicleResponse) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
