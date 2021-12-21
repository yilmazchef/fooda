package be.fooda.backend.ranking.model.remote;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerClientResponse {

    Long customerId;
    String firstName;
    String lastName;
    String companyName;
    String profileImageUrl;

}
