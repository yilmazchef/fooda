package be.fooda.backend.order.dao;

import be.fooda.backend.order.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    boolean existsByStoreIdAndCustomerIdAndDeliveryId(Long storeId, Long customerId, Long deliveryId);


}
