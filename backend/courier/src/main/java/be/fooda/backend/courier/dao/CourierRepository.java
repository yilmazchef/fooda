package be.fooda.backend.courier.dao;

import be.fooda.backend.courier.model.entity.CourierEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<CourierEntity, Long> {

    List<CourierEntity> findAllByUserId(@NotNull Long userId);

    @Modifying
    @Query("update couriers c set c.isActive = false where c.id = :id")
    int makePassive(@Param("id") Long id);

    boolean existsByIdAndIsActive(Long id, boolean isActive);

    boolean existsByUserIdAndFirstNameAndFamilyName(@NotNull Long userId, @NotNull String firstName, @NotNull String familyName);

}
