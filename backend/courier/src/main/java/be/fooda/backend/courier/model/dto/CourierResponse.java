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
public class CourierResponse implements Serializable{

    Long courierId;

    public CourierResponse withCourierId(Long courierId) {
        this.courierId = courierId;
        return this;
    }

    String firstName;

    String familyName;

    String company;

    Long userId;

    Long addressId;

    Long contactId;

    String dateOfBirth;

    String profileImageUrl;

    String note;

    Set<CreateVehicleRequest> vehicles = new LinkedHashSet<>();

    public void addVehicle(CreateVehicleRequest price) {
        this.vehicles.add(price);
    }

    public void removeVehicle(CreateVehicleRequest price) {
        this.vehicles.remove(price);
    }

    public CourierResponse withVehicles(Set<CreateVehicleRequest> vehicles) {
        this.setVehicles(vehicles);
        return this;
    }

    public CourierResponse withVehicle(CreateVehicleRequest price) {
        this.addVehicle(price);
        return this;
    }

    public CourierResponse withoutVehicle(CreateVehicleRequest price) {
        this.removeVehicle(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourierResponse)) return false;
        CourierResponse that = (CourierResponse) o;
        return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getFamilyName(), that.getFamilyName()) && Objects.equals(getCompany(), that.getCompany()) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getAddressId(), that.getAddressId()) && Objects.equals(getContactId(), that.getContactId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getFamilyName(), getCompany(), getUserId(), getAddressId(), getContactId());
    }
}
