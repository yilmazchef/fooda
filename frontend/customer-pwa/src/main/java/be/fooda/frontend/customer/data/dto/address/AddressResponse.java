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
public class AddressResponse {

    Long addressId;
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
    CoordinateResponse coordinate;
    UserResponse user;

    public AddressResponse withAddressId(Long id) {
        this.addressId = id;
        return this;
    }

    public AddressResponse withDoor(String door) {
        this.door = door;
        return this;
    }

    public AddressResponse withHouse(String house) {
        this.house = house;
        return this;
    }

    public AddressResponse withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressResponse withMunicipality(String municipality) {
        this.municipality = municipality;
        return this;
    }

    public AddressResponse withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public AddressResponse withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressResponse withRegion(String region) {
        this.region = region;
        return this;
    }

    public AddressResponse withCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressResponse withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public AddressResponse withActive(Boolean active) {
        isActive = active;
        return this;
    }

    public AddressResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    public AddressResponse withCurrent(Boolean current) {
        isCurrent = current;
        return this;
    }

    public AddressResponse withRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
        return this;
    }

    public AddressResponse withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public AddressResponse withCoordinate(CoordinateResponse coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public AddressResponse withUser(UserResponse user) {
        this.user = user;
        return this;
    }

    public AddressResponse withUser(Long userId) {
        this.user = new UserResponse().withUserId(userId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressResponse)) return false;
        AddressResponse that = (AddressResponse) o;
        return Objects.equals(getDoor(), that.getDoor()) && Objects.equals(getHouse(), that.getHouse()) && getStreet().equals(that.getStreet()) && Objects.equals(getMunicipality(), that.getMunicipality()) && getPostcode().equals(that.getPostcode()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getRegion(), that.getRegion()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getCountryCode(), that.getCountryCode()) && getUser().equals(that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoor(), getHouse(), getStreet(), getMunicipality(), getPostcode(), getCity(), getRegion(), getCountry(), getCountryCode(), getUser().getUserId());
    }
}
