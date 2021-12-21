package be.fooda.frontend.customer.data.dto.basket;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "mediaId" })

// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateMediaRequest {

    Long mediaId;

    String url;

    public CreateMediaRequest withMediaId(Long mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    public CreateMediaRequest withUrl(String url) {
        this.url = url;
        return this;
    }
}
