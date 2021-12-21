package be.fooda.backend.courier.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
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
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCourierRequest implements Serializable{

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

    public CreateCourierRequest withVehicles(Set<CreateVehicleRequest> vehicles) {
        this.setVehicles(vehicles);
        return this;
    }

    public CreateCourierRequest withVehicle(CreateVehicleRequest price) {
        this.addVehicle(price);
        return this;
    }

    public CreateCourierRequest withoutVehicle(CreateVehicleRequest price) {
        this.removeVehicle(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateCourierRequest)) return false;
        CreateCourierRequest that = (CreateCourierRequest) o;
        return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getFamilyName(), that.getFamilyName()) && Objects.equals(getCompany(), that.getCompany()) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getAddressId(), that.getAddressId()) && Objects.equals(getContactId(), that.getContactId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getFamilyName(), getCompany(), getUserId(), getAddressId(), getContactId());
    }
}
