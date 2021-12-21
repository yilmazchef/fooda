package be.fooda.backend.review.model.remote;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreClientResponse {

    Long storeId;
    String title;
    String logoUrl;

}
