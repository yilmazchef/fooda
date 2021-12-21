package be.fooda.backend.payment.model.entity;

import be.fooda.backend.commons.model.payment.FoodaPaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.SortableField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodaPaymentItem {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Payment amount must be greater than zero.")
    @Positive
    @Field
    @SortableField
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @IndexedEmbedded
    private FoodaPaymentMethod paymentMethod;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    @ContainedIn
    private FoodaPayment payment;
}
