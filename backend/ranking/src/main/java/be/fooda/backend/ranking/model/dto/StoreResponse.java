package be.fooda.backend.ranking.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreResponse {

    String id;
    Long storeId;
    Integer ranking;
    String session;
    Long addressId;
    Long contactId;
    String logoUrl;
}
