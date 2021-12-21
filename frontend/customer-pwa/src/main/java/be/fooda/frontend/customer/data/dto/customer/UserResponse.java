package be.fooda.frontend.customer.data.dto.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long id;
    Long userId;
    String username;

    public UserResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public UserResponse withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public UserResponse withUsername(String username) {
        this.username = username;
        return this;
    }
}