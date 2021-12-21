package be.fooda.backend.inventory.service.impl;
import be.fooda.backend.inventory.dao.FoodaInventoryRepository;
import be.fooda.backend.inventory.model.dto.FoodaInventoryDTO;
import be.fooda.backend.inventory.model.entity.FoodaInventory;
import be.fooda.backend.inventory.service.FoodaInventoryService;
import be.fooda.backend.inventory.service.mapper.FoodaInventoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodaInventoryServiceImpl  implements FoodaInventoryService<FoodaInventoryDTO, FoodaInventory> {

    private final FoodaInventoryRepository inventoryRepository;
    private final FoodaInventoryMapper inventoryMapper;

    @Override
    public Optional<FoodaInventory> getById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public Optional<FoodaInventory> getByExample(FoodaInventoryDTO dto) {
        return inventoryRepository.findOne(Example.of(inventoryMapper.toEntity(dto)));
    }

    @Override
    public List<FoodaInventory> getByStore(Long storeId) {
        return inventoryRepository.findByStoreId(storeId);
    }

    @Override
    public List<FoodaInventory> getByProductAndStore(Long productId, Long storeId) {
        return inventoryRepository.findByProductIdAndStoreId(storeId,productId);
    }

    @Override
    public List<FoodaInventory> getAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<FoodaInventory> add(FoodaInventoryDTO dto) {

        return Optional.of(inventoryRepository.save(inventoryMapper.toEntity(dto)));
    }

    @Override
    public Optional<FoodaInventory> editById(Long id, FoodaInventoryDTO dto) {
        final Optional<FoodaInventory> oFoundInventory = inventoryRepository.findById(id);
        return oFoundInventory.map(inventory -> edit(dto, inventory));
    }

    private FoodaInventory edit(FoodaInventoryDTO dto, FoodaInventory inventory) {
        final FoodaInventory inventoryToUpdate = inventoryMapper.toEntity(dto, inventory);
        return inventoryRepository.save(inventoryToUpdate);
    }

    @Override
    public Optional<FoodaInventory> editByExample(FoodaInventoryDTO find, FoodaInventoryDTO update) {
        final Optional<FoodaInventory> oFoundInventory = inventoryRepository.findOne(Example.of(
                inventoryMapper.toEntity(find),
                ExampleMatcher.matching().withIgnoreNullValues()));
        return oFoundInventory.map(inventory -> edit(update, inventory));
    }

    @Override
    public Optional<FoodaInventory> removeById(Long id) {
        final Optional<FoodaInventory>  foundInventory = getById(id);
        foundInventory.ifPresent( inventory -> inventoryRepository.deleteById(id));
        return foundInventory;
    }

    @Override
    public Optional<FoodaInventory> removeByExample(FoodaInventoryDTO dto) {
        final Optional<FoodaInventory> foundInventory = getByExample(dto);
        foundInventory.ifPresent(inventoryRepository :: delete);
        return foundInventory;
    }

    @Override
    public Boolean existsById(Long id) {
        return inventoryRepository.existsById(id);
    }

    @Override
    public Boolean existsByExample(FoodaInventoryDTO dto) {
        return inventoryRepository.exists(Example.of(inventoryMapper.toEntity(dto)));
    }
}
