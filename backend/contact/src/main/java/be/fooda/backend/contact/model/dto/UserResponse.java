package be.fooda.backend.contact.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    Long userId;

    String title;

    public UserResponse withUserId(Long storeId) {
        this.userId = storeId;
        return this;
    }

    public UserResponse withTitle(String title) {
        this.title = title;
        return this;
    }

}
