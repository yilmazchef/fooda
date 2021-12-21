package be.fooda.backend.customer.dao;

import be.fooda.backend.customer.model.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    boolean existsByUserIdAndFirstNameAndFamilyName (Long userId, String firstName, String familyName);

    boolean existsByFirstNameAndFamilyName (String firstName, String familyName);

    Optional<CustomerEntity> findByUserIdAndFirstNameAndFamilyName(Long userId, String firstName, String familyName);

    Page<CustomerEntity> findAllByIsActive(Boolean isActive, Pageable pageable);

    List<CustomerEntity> findAllByUserId(Long userId);

}

