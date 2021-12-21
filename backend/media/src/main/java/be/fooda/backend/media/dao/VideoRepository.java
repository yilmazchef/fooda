package be.fooda.backend.media.dao;

import be.fooda.backend.media.model.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

    Boolean existsByIdAndIsActive(Long id, Boolean isActive);

    @Modifying
    @Query("update videos v set v.isActive = false where v.id = :id")
    int makePassive(@Param("id") Long id);

    Optional<VideoEntity> findByUserIdAndRelatedId(Long userId, Long relatedId);

    Boolean existsByUserIdAndRelatedId(Long userId, Long relatedId);
}
