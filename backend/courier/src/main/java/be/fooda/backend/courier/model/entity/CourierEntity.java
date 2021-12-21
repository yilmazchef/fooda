package be.fooda.backend.courier.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
@Entity(name = "couriers")
// HIBERNATE SEARCH
@Indexed
public class CourierEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    public CourierEntity withId(Long id) {
        this.id = id;
        return this;
    }

    Boolean isActive = Boolean.TRUE;

    public CourierEntity withActive(Boolean active) {
        isActive = active;
        return this;
    }

    @NotNull
    String firstName;

    @NotNull
    String familyName;

    String company;

    @NotNull
    Long userId;

    Long addressId;

    Long contactId;

    String dateOfBirth;

    String profileImageUrl;

    String note;

    @IndexedEmbedded(includeDepth = 1)
    @OneToMany(mappedBy = "courier", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    Set<VehicleEntity> vehicles = new LinkedHashSet<>();

    public void setVehicles(Set<VehicleEntity> vehicles) {
        this.vehicles = vehicles;
        for (VehicleEntity price : this.vehicles) {
            price.setCourier(this);
        }
    }

    public void addVehicle(VehicleEntity price) {
        price.setCourier(this);
        this.vehicles.add(price);
    }

    public void removeVehicle(VehicleEntity price) {
        price.setCourier(this);
        this.vehicles.remove(price);
    }

    public CourierEntity withVehicles(Set<VehicleEntity> vehicles) {
        this.setVehicles(vehicles);
        return this;
    }

    public CourierEntity withVehicle(VehicleEntity price) {
        this.addVehicle(price);
        return this;
    }

    public CourierEntity withoutVehicle(VehicleEntity price) {
        this.removeVehicle(price);
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
        CourierEntity that = (CourierEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
