package be.fooda.backend.payment.dao;

import be.fooda.backend.payment.model.entity.PaymentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    Page<PaymentEntity> findAllByIsActive(Boolean isActive, Pageable pageable);

    Page<PaymentEntity> findAllByTitleContains(String title, Pageable pageable);

    Optional<PaymentEntity> findByTitleAndStoreId(String title, Long storeId);

    boolean existsByTitleAndStoreId(String title, Long storeId);

    @Modifying
    @Query("update payments p set p.isActive = false where p.id = :id")
    int makePassive(@Param("id") Long id);

    boolean existsByIdAndIsActive(Long id, boolean isActive);

}
