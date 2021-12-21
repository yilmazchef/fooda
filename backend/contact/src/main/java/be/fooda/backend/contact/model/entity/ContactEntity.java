package be.fooda.backend.contact.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JPA
@Entity(name = "contacts")
// HIBERNATE SEARCH
@Indexed
public class ContactEntity implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    Long userId;

    @FullTextField
    @NotNull
    String firstName;

    @FullTextField
    @NotNull
    String familyName;

    @FullTextField
    String companyName;

    String mobilePhoneNumber;

    String linePhoneNumber;

    @Email
    String email;

    Boolean canCall;

    Boolean isActive;

    @FullTextField
    String title;

    Boolean isCurrent;

    String created;

    String registered;

    String updated;

    public ContactEntity withId(Long id) {
        this.id = id;
        return this;
    }

    public ContactEntity withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public ContactEntity withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactEntity withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public ContactEntity withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ContactEntity withMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    public ContactEntity withLinePhoneNumber(String linePhoneNumber) {
        this.linePhoneNumber = linePhoneNumber;
        return this;
    }

    public ContactEntity withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactEntity withCanCall(Boolean canCall) {
        this.canCall = canCall;
        return this;
    }

    public ContactEntity withActive(Boolean active) {
        isActive = active;
        return this;
    }

    public ContactEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactEntity withCurrent(Boolean current) {
        isCurrent = current;
        return this;
    }

    public ContactEntity withCreated(String created) {
        this.created = created;
        return this;
    }

    public ContactEntity withRegistered(String registered) {
        this.registered = registered;
        return this;
    }

    public ContactEntity withUpdated(String updated) {
        this.updated = updated;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactEntity)) return false;
        ContactEntity that = (ContactEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }

    @PrePersist
    public void prePersist() {
        this.setIsActive(Boolean.TRUE);
        this.setRegistered(getNow());
    }

    @PreUpdate
    public void preUpdate() {
        this.setUpdated(getNow());
    }

    private String getNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z");
        return zonedDateTime.format(formatter);
    }
}