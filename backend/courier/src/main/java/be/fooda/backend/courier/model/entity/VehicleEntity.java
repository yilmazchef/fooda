package be.fooda.backend.courier.model.entity;

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
// JPA
@Entity(name = "categories")
public class VehicleEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    public VehicleEntity withId(Long id) {
        this.id = id;
        return this;
    }

    @FullTextField
    @Column(nullable = false)
    String title;

    public VehicleEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    @ElementCollection
    @CollectionTable(name = "vehicle_photos", joinColumns = @JoinColumn(name = "vehicle_id"))
    @Column(name = "media_id")
    Set<Long> photos = new LinkedHashSet<>();

    public void addPhoto(Long mediaId) {
        this.photos.add(mediaId);
    }

    public void removePhoto(Long mediaId) {
        this.photos.remove(mediaId);
    }

    @ToString.Exclude
    @JoinColumn(name = "courier_id")
    @ManyToOne
    CourierEntity courier;

    public VehicleEntity withCourierId(Long courierId) {
        this.courier.setId(courierId);
        return this;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VehicleEntity that = (VehicleEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
