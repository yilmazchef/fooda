package be.fooda.frontend.customer.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

    USER("user"), ADMIN("admin");

    private final String roleName;

}
