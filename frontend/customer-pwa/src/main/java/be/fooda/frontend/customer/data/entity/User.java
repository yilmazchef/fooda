package be.fooda.frontend.customer.data.entity;

import javax.persistence.Entity;

import be.fooda.frontend.customer.data.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import be.fooda.frontend.customer.data.Role;
import lombok.AccessLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User extends AbstractEntity {

    String username;
    String name;
    @JsonIgnore
    String hashedPassword;
    @ElementCollection(fetch = FetchType.EAGER)
    Set<Role> roles;
    @Lob
    String profilePictureUrl;


    public User withUsername(String username) {
        setUsername(username);
        return this;
    }

    public User withName(String name) {
        setName(name);
        return this;
    }

    public User withHashedPassword(String hashedPassword) {
        setHashedPassword(hashedPassword);
        return this;
    }

    public User withRoles(Set<Role> roles) {
        setRoles(roles);
        return this;
    }

    public User withProfilePictureUrl(String profilePictureUrl) {
        setProfilePictureUrl(profilePictureUrl);
        return this;
    }


}
