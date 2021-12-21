package be.fooda.backend.address.dao;

import be.fooda.backend.address.model.entity.AddressEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> findAllByIsActive(Boolean isActive, Pageable pageable);

    List<AddressEntity> findAllByTitleContains(String title);

    Optional<AddressEntity> findByTitleAndUserId(String title, Long userId);

    boolean existsByTitleAndUserId(String title, Long userId);

    @Modifying
    @Query("update addresses a set a.isActive = false where a.id = :id")
    int makePassive(@Param("id") Long id);

    boolean existsByIdAndIsActive(Long id, boolean isActive);

}
