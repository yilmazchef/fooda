package be.fooda.backend.payment.dao;

import be.fooda.backend.payment.model.entity.FoodaPaymentOrder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface FoodaPaymentOrderRepository
        extends JpaRepository<FoodaPaymentOrder, Long> {

    Optional<FoodaPaymentOrder> findByPayment_Id(Long paymentId);

    boolean existsByPayment_Id(Long paymentId);

    List<FoodaPaymentOrder> deleteByPayment_Id(Long paymentId);

}
