package be.fooda.backend.basket.model.document;


import jdk.jfr.BooleanFlag;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(value = "basket_document")
public class BasketDocument {

    @Id
    String id;

    @NotNull
    String session;

    CustomerDocument customer;
    StoreDocument store;
    Boolean active = Boolean.TRUE;
    BigDecimal totalPrice;
    Set<ProductDocument> products = new LinkedHashSet<>();
    Set<PaymentDocument> payments = new LinkedHashSet<>();

    @CreatedDate
    LocalDateTime createdAt; //expiration time 2 saat

    @LastModifiedDate
    LocalDateTime updatedAt;

    {
        if(!products.isEmpty()){
            setTotalPrice();
        }
    }

    public void setTotalPrice(){
        totalPrice = products.stream()
                .map(product -> product.getPrice())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }


}
