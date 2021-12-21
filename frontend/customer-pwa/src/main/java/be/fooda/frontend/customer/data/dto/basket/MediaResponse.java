package be.fooda.frontend.customer.data.dto.basket;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

// LOMBOK
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = { "mediaId" })

// JACKSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaResponse {

    Long mediaId;

    String url;

    public MediaResponse withMediaId(Long mediaId) {
        this.mediaId = mediaId;
        return this;
    }

    public MediaResponse withUrl(String url) {
        this.url = url;
        return this;
    }
}
