package be.fooda.backend.payment.dao;

import be.fooda.backend.payment.model.entity.FoodaPaymentStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface FoodaPaymentStoreRepository
        extends JpaRepository<FoodaPaymentStore, Long> {

    List<FoodaPaymentStore> findByOrder_Payment_Id(Long paymentId);

    boolean existsByOrder_Payment_Id(Long paymentId);

    List<FoodaPaymentStore> deleteByOrder_Payment_Id(Long paymentId);

    List<FoodaPaymentStore> findByOrder_ExternalOrderId(Long externalOrderId);

    boolean existsByOrder_ExternalOrderId(Long externalOrderId);

    List<FoodaPaymentStore> deleteByOrder_ExternalOrderId(Long externalOrderId);
}
