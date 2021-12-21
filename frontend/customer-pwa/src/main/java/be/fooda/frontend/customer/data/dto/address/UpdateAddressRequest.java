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

public class UpdateAddressRequest {
    Long id;
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
    UpdateCoordinateRequest coordinate;
    Long userId;

    public UpdateAddressRequest withId(Long id) {
        this.id = id;
        return this;
    }

    public UpdateAddressRequest withDoor(String door) {
        this.door = door;
        return this;
    }

    public UpdateAddressRequest withHouse(String house) {
        this.house = house;
        return this;
    }

    public UpdateAddressRequest withStreet(String street) {
        this.street = street;
        return this;
    }

    public UpdateAddressRequest withMunicipality(String municipality) {
        this.municipality = municipality;
        return this;
    }

    public UpdateAddressRequest withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public UpdateAddressRequest withCity(String city) {
        this.city = city;
        return this;
    }

    public UpdateAddressRequest withRegion(String region) {
        this.region = region;
        return this;
    }

    public UpdateAddressRequest withCountry(String country) {
        this.country = country;
        return this;
    }

    public UpdateAddressRequest withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public UpdateAddressRequest withActive(Boolean active) {
        isActive = active;
        return this;
    }

    public UpdateAddressRequest withTitle(String title) {
        this.title = title;
        return this;
    }

    public UpdateAddressRequest withCurrent(Boolean current) {
        isCurrent = current;
        return this;
    }

    public UpdateAddressRequest withRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
        return this;
    }

    public UpdateAddressRequest withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public UpdateAddressRequest withCoordinate(UpdateCoordinateRequest coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public UpdateAddressRequest withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateAddressRequest)) return false;
        UpdateAddressRequest that = (UpdateAddressRequest) o;
        return Objects.equals(getDoor(), that.getDoor()) && Objects.equals(getHouse(), that.getHouse()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getMunicipality(), that.getMunicipality()) && Objects.equals(getPostcode(), that.getPostcode()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getRegion(), that.getRegion()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getCountryCode(), that.getCountryCode()) && Objects.equals(getCoordinate(), that.getCoordinate()) && getUserId().equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoor(), getHouse(), getStreet(), getMunicipality(), getPostcode(), getCity(), getRegion(), getCountry(), getCountryCode(), getCoordinate(), getUserId());
    }
}
