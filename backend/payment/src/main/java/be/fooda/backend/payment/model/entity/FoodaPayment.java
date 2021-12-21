package be.fooda.backend.payment.model.entity;

import be.fooda.backend.commons.model.payment.FoodaPaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.SortableField;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Indexed
public class FoodaPayment {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean isActive = Boolean.TRUE;

    private FoodaPaymentStatus status;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    @IndexedEmbedded
    private List<FoodaPaymentItem> items;

    public void setItems(List<FoodaPaymentItem> items) {
        this.items = items
                .stream()
                .map(this::setOneItem)
                .collect(Collectors.toList());
    }

    private FoodaPaymentItem setOneItem(FoodaPaymentItem item) {
        item.setPayment(this);
        return item;
    }

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    @IndexedEmbedded
    private FoodaPaymentUser user;

    public void setUser(FoodaPaymentUser user) {
        user.setPayment(this);
        this.user = user;
    }

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    @IndexedEmbedded
    private FoodaPaymentOrder order;

    public void setOrder(FoodaPaymentOrder order) {
        order.setPayment(this);
        this.order = order;
    }

    @SortableField
    @Field
    @CreationTimestamp
    private LocalDateTime created;

    @SortableField
    @Field
    @UpdateTimestamp
    private LocalDateTime updated;

    @Lob
    @Field
    private String note;
}
