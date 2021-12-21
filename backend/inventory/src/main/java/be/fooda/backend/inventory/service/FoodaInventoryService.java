package be.fooda.backend.inventory.service;

import java.util.List;
import java.util.Optional;

public interface FoodaInventoryService <D, E>{

    Optional<E> getById(final Long id);

    Optional<E> getByExample(final D d);

    List<E> getByStore(Long storeId);

    List<E> getByProductAndStore(final Long productId, final Long storeId);

    List<E> getAll();

    Optional<E> add(final D req);

    Optional<E> editById(final Long inventoryId, final D dto);

    Optional<E> editByExample(final D find, final D update);

    Optional<E> removeById(final Long id);

    Optional<E> removeByExample(final D dto);

    Boolean existsById(final Long id);

    Boolean existsByExample(final D dto);

}
