package be.fooda.backend.payment.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.time.Instant;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodaPaymentOrder {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @EqualsAndHashCode.Include
    @Field
    private Long externalOrderId;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    @IndexedEmbedded
    private FoodaPaymentStore store;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    @ContainedIn
    private FoodaPayment payment;

    public void setStore(FoodaPaymentStore store) {
        store.setOrder(this);
        this.store = store;
    }
}
