package be.fooda.backend.address.model.dto;

import be.fooda.backend.address.model.entity.CoordinateEntity;
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

public class CreateAddressRequest {

    String door;
    String house;
    String street;
    String municipality;
    String postcode;
    String city;
    String region;
    String country;
    String countryCode;
    Boolean isActive = Boolean.TRUE;
    String title;
    Boolean isCurrent;
    String registeredAt;
    String updatedAt;
    CoordinateEntity coordinate;
    Long userId;

    public CreateAddressRequest withDoor(String door) {
        this.door = door;
        return this;
    }

    public CreateAddressRequest withHouse(String house) {
        this.house = house;
        return this;
    }

    public CreateAddressRequest withStreet(String street) {
        this.street = street;
        return this;
    }

    public CreateAddressRequest withMunicipality(String municipality) {
        this.municipality = municipality;
        return this;
    }

    public CreateAddressRequest withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public CreateAddressRequest withCity(String city) {
        this.city = city;
        return this;
    }

    public CreateAddressRequest withRegion(String region) {
        this.region = region;
        return this;
    }

    public CreateAddressRequest withCountry(String country) {
        this.country = country;
        return this;
    }

    public CreateAddressRequest withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public CreateAddressRequest withActive(Boolean active) {
        isActive = active;
        return this;
    }

    public CreateAddressRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateAddressRequest withCurrent(Boolean current) {
        isCurrent = current;
        return this;
    }

    public CreateAddressRequest withRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
        return this;
    }

    public CreateAddressRequest withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public CreateAddressRequest withCoordinate(CoordinateEntity coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public CreateAddressRequest withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateAddressRequest)) return false;
        CreateAddressRequest that = (CreateAddressRequest) o;
        return Objects.equals(getDoor(), that.getDoor()) && Objects.equals(getHouse(), that.getHouse()) && getStreet().equals(that.getStreet()) && Objects.equals(getMunicipality(), that.getMunicipality()) && getPostcode().equals(that.getPostcode()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getRegion(), that.getRegion()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getCountryCode(), that.getCountryCode()) && Objects.equals(getCoordinate(), that.getCoordinate()) && getUserId().equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoor(), getHouse(), getStreet(), getMunicipality(), getPostcode(), getCity(), getRegion(), getCountry(), getCountryCode(), getCoordinate(), getUserId());
    }
}
