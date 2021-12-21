package be.fooda.backend.payment.dao;

import be.fooda.backend.payment.model.entity.FoodaPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FoodaPaymentRepository extends JpaRepository<FoodaPayment, Long> {

    List<FoodaPayment> findByOrder_Store_ExternalStoreId(Long externalStoreId);

    Optional<FoodaPayment> findByOrder_ExternalOrderId(Long externalOrderId);

    List<FoodaPayment> findByUser_ExternalUserId(Long externalUserId);

    boolean existsByOrder_ExternalOrderId(Long externalOrderId);

    List<FoodaPayment> deleteByOrder_ExternalOrderId(Long externalOrderId);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM FoodaPayment p " +
            "WHERE p.order.store.externalStoreId = :externalStoreId " +
            "AND p.user.externalUserId = :externalUserId")
    boolean existByUniqueFields(@Param("externalStoreId") Long externalStoreId, @Param("externalUserId") Long externalUserId);

}
