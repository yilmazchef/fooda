package be.fooda.backend.inventory.dao;

import be.fooda.backend.inventory.model.entity.FoodaInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaInventoryRepository extends JpaRepository<FoodaInventory, Long> {

    List<FoodaInventory> findByStoreId(final Long id);

    List<FoodaInventory> findByProductIdAndStoreId(final Long productId, final Long storeId);

    List<FoodaInventory> findBySku(final String sku);
    
}
