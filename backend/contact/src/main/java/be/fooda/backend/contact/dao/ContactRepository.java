package be.fooda.backend.contact.dao;

import be.fooda.backend.contact.model.entity.ContactEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    List<ContactEntity> findAllByIsActive(Boolean isActive, Pageable pageable);

    List<ContactEntity> findAllByTitleContains(String title);

    Optional<ContactEntity> findByTitleAndUserId(String title, Long userId);

    boolean existsByTitleAndUserId(String title, Long userId);

    @Modifying
    @Query("update contacts c set c.isActive = false where c.id = :id")
    int makePassive(@Param("id") Long id);

    boolean existsByIdAndIsActive(Long id, boolean isActive);

}
