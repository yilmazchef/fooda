package be.fooda.backend.address.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// JPA
@Entity(name = "addresses")
// HIBERNATE SEARCH
@Indexed
public class AddressEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String door;

    @FullTextField
    String house;

    @FullTextField
    String street;

    @FullTextField
    String municipality;

    @FullTextField
    String postcode;

    @FullTextField
    String city;

    @FullTextField
    String region;

    @FullTextField
    String country;

    @FullTextField
    String countryCode;

    Boolean isActive = Boolean.TRUE;

    @FullTextField
    String title;

    Boolean isCurrent;

    String registeredAt;

    String updatedAt;

    Long userId;

    @Embedded
    CoordinateEntity coordinate;

    public AddressEntity withId(Long id) {
        this.id = id;
        return this;
    }

    public AddressEntity withDoor(String door) {
        this.door = door;
        return this;
    }

    public AddressEntity withHouse(String house) {
        this.house = house;
        return this;
    }

    public AddressEntity withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressEntity withMunicipality(String municipality) {
        this.municipality = municipality;
        return this;
    }

    public AddressEntity withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public AddressEntity withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressEntity withRegion(String region) {
        this.region = region;
        return this;
    }

    public AddressEntity withCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressEntity withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public AddressEntity withActive(Boolean active) {
        isActive = active;
        return this;
    }

    public AddressEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    public AddressEntity withCurrent(Boolean current) {
        isCurrent = current;
        return this;
    }

    public AddressEntity withRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
        return this;
    }

    public AddressEntity withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public AddressEntity withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public AddressEntity withCoordinate(CoordinateEntity coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressEntity)) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
