package be.fooda.backend.customer.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
//JPA
@Entity(name = "customers")
// HIBERNATE SEARCH
@Indexed
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Boolean isActive = Boolean.TRUE;

    @FullTextField
    String validation;

    @FullTextField
    String title;

    @FullTextField
    String firstName;

    @FullTextField
    String familyName;

    @FullTextField
    String companyName;

    @FullTextField
    String dateOfBirth;

    @FullTextField
    String note;

    String createdAt;
    String updatedAt;
    Long userId;
    Long addressId;
    Long contactId;

    @ElementCollection
    @CollectionTable(name = "payment_options", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "payment_option_id")
    Set<Long> paymentOptions = new LinkedHashSet<>();

    public void addPaymentOption(Long paymentOptionId) {
        this.paymentOptions.add(paymentOptionId);
    }

    public void removePaymentOption(Long paymentOptionId) {
        this.paymentOptions.remove(paymentOptionId);
    }

    @ElementCollection
    @CollectionTable(name = "favorite_products", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "product_id")
    Set<Long> favoriteProducts = new LinkedHashSet<>();

    public void addFavoriteProduct(Long favoriteProductId) {
        this.favoriteProducts.add(favoriteProductId);
    }

    public void removeFavoriteProduct(Long favoriteProductId) {
        this.favoriteProducts.remove(favoriteProductId);
    }

    @ElementCollection
    @CollectionTable(name = "favorite_orders", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "order_id")
    Set<Long> favoriteOrders = new LinkedHashSet<>();

    public void addFavoriteOrders(Long favoriteOrdersId) {
        this.favoriteOrders.add(favoriteOrdersId);
    }

    public void removeFavoriteOrders(Long favoriteOrdersId) {
        this.favoriteOrders.remove(favoriteOrdersId);
    }

    @ElementCollection
    @CollectionTable(name = "favorite_stores", joinColumns = @JoinColumn(name = "customer_id"))
    @Column(name = "store_id")
    Set<Long> favoriteStores = new LinkedHashSet<>();

    public void addFavoriteStores(Long favoriteStoreId) {
        this.favoriteOrders.add(favoriteStoreId);
    }

    public void removeFavoriteStores(Long favoriteStoreId) {
        this.favoriteOrders.remove(favoriteStoreId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerEntity)) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @PrePersist
    private void prePersistFunction() {
        log.info("PrePersist method called. Auto-persistable fields are being managed.");
        this.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
        this.setIsActive(true);
    }

    @PreUpdate
    public void preUpdateFunction() {
        log.info("PreUpdate method called. Auto-updatable fields are being managed.");
        this.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
    }
}
