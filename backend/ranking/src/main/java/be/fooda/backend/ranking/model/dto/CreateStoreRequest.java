package be.fooda.backend.ranking.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateStoreRequest {

    Long storeId;
    Integer ranking;
    String session;
    Long addressId;
    Long contactId;
}
