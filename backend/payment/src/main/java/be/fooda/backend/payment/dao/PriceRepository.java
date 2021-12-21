package be.fooda.backend.payment.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import be.fooda.backend.payment.model.entity.PaymentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import be.fooda.backend.payment.model.entity.PriceEntity;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("select p from prices p where p.payment.id = :paymentId")
    Set<PriceEntity> findByPaymentId(Long paymentId);

    @Query("select p from prices p where p.payment.id = :paymentId")
    Page<PriceEntity> findByPaymentId(Long paymentId, Pageable pageable);

    @Query("select p from prices p where p.payment.id = :paymentId and p.isDefault = true")
    Optional<PriceEntity> findByPaymentIdAndDefault(Long paymentId);

}
