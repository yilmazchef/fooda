package be.fooda.backend.review.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateStoreRequest {

    Long storeId;
    String review;
    String session;
    Long addressId;
    Long contactId;
    String logoUrl;
}
