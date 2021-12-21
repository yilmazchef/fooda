package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactResponse {

    Long id;
    Long contactId;
    String phone;
    String email;
    Boolean canCall;

    public ContactResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public ContactResponse withContactId(Long contactId) {
        this.contactId = contactId;
        return this;
    }

    public ContactResponse withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactResponse withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactResponse withCanCall(Boolean canCall) {
        this.canCall = canCall;
        return this;
    }
}