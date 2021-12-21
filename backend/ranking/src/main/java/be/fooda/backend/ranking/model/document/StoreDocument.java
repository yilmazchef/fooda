package be.fooda.backend.ranking.model.document;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
public class StoreDocument {

    @Id
    String id;

    @Min(1)
    @Max(10)
    Integer ranking;

    Long storeId;

    String session;

    Long addressId;

    Long contactId;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

    Boolean active;

    public StoreDocument withId(String id) {
        this.id = id;
        return this;
    }

    public StoreDocument withRanking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public StoreDocument withStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public StoreDocument withSession(String session) {
        this.session = session;
        return this;
    }

    public StoreDocument withAddressId(Long addressId) {
        this.addressId = addressId;
        return this;
    }

    public StoreDocument withContactId(Long contactId) {
        this.contactId = contactId;
        return this;
    }

    public StoreDocument withActive(Boolean active) {
        this.active = active;
        return this;
    }
}
