package be.fooda.backend.media.dao;

import be.fooda.backend.media.model.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

    Boolean existsByIdAndIsActive(Long id, Boolean isActive);

    @Modifying
    @Query("update images i set i.isActive = false where i.id = :id")
    int makePassive(@Param("id") Long id);

    Optional<ImageEntity> findByUserIdAndRelatedId(Long relatedId, Long userId);

    Boolean existsByUserIdAndRelatedId(Long userId, Long relatedId);

}
