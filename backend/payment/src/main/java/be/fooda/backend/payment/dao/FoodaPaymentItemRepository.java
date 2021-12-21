package be.fooda.backend.payment.dao;

import be.fooda.backend.payment.model.entity.FoodaPaymentItem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FoodaPaymentItemRepository
        extends JpaRepository<FoodaPaymentItem, Long> {

    List<FoodaPaymentItem> findByPayment_Id(Long paymentId);

    List<FoodaPaymentItem> deleteByPayment_Id(Long paymentId);

    boolean existsByPayment_Id(Long paymentId);
}
