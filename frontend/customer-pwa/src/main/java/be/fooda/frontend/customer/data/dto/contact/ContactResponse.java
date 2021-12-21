package be.fooda.frontend.customer.data.dto.contact;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Jacksonized
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactResponse {

    private UUID id;

    private UserResponse user;

    private String firstName;

    private String familyName;

    private String companyName;

    private String mobilePhoneNumber;

    private String linePhoneNumber;

    private String email;

    private Boolean canCall;

    private Boolean isActive;

    private String title;

    private Boolean isCurrent;

    private Timestamp creationTime;

    private Timestamp registryTime;

    private Timestamp updateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactResponse)) return false;
        ContactResponse that = (ContactResponse) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}