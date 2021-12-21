package be.fooda.backend.payment.dao;

import be.fooda.backend.payment.model.entity.FoodaPaymentUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodaPaymentUserRepository
        extends JpaRepository<FoodaPaymentUser, Long> {

    Optional<FoodaPaymentUser> findByPayment_Id(Long paymentId);

    boolean existsByPayment_Id(Long paymentId);

    List<FoodaPaymentUser> deleteByPayment_Id(Long paymentId);

}
