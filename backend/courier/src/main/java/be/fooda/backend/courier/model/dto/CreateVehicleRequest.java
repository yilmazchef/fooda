package be.fooda.backend.courier.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
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
public class CreateVehicleRequest implements Serializable {

    Long id;

    public CreateVehicleRequest withId(Long id) {
        this.id = id;
        return this;
    }

    String title;

    public CreateVehicleRequest withTitle(String title) {
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
        if (!(o instanceof CreateVehicleRequest)) return false;
        CreateVehicleRequest that = (CreateVehicleRequest) o;
        return Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
