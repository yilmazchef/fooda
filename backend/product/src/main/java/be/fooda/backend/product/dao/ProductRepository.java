package be.fooda.backend.product.dao;

import be.fooda.backend.product.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Page<ProductEntity> findAllByIsActive(Boolean isActive, Pageable pageable);

    Page<ProductEntity> findAllByTitleContains(String title, Pageable pageable);

    Optional<ProductEntity> findByTitleAndStoreId(String title, Long storeId);

    boolean existsByTitleAndStoreId(String title, Long storeId);

    @Modifying
    @Query("update products p set p.isActive = false where p.id = :id")
    int makePassive(@Param("id") Long id);

    boolean existsByIdAndIsActive(Long id, boolean isActive);

}
