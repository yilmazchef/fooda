package be.fooda.backend.delivery.dao;

import be.fooda.backend.delivery.model.entity.DeliveryEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long>,
        JpaSpecificationExecutor<DeliveryEntity> {


   boolean existsByOrderIdAndStoreId(Long orderId,Long storeId);

   Optional<DeliveryEntity> findByOrderIdAndStoreId(Long orderId, Long storeId );

   @Modifying
   @Query("update deliveries p set p.active = false where p.id = :deliveryId")
   int makePassive(@Param("deliveryId") Long deliveryId);

   List<DeliveryEntity> findAllByActive(Boolean active, Pageable pagable);
}
