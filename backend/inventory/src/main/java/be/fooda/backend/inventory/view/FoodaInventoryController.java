package be.fooda.backend.inventory.view;

import be.fooda.backend.inventory.exception.ResourceAlreadyExistsException;
import be.fooda.backend.inventory.exception.ResourceNotFoundException;
import be.fooda.backend.inventory.model.dto.FoodaInventoryDTO;
import be.fooda.backend.inventory.model.entity.FoodaInventory;
import be.fooda.backend.inventory.service.FoodaInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("inventory")
@Validated
public class FoodaInventoryController {

    private final FoodaInventoryService<FoodaInventoryDTO, FoodaInventory> inventoryService;
    
    @GetMapping("all")
    public ResponseEntity<List<FoodaInventory>> readAll() {
        final List<FoodaInventory> inventories = inventoryService.getAll();
        return !inventories.isEmpty()
                ? ResponseEntity.ok(inventories)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<FoodaInventory> readById(@PathVariable Long id) {
        return inventoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory with " + id + " NOT found!"));
    }

    @GetMapping("example")
    public ResponseEntity<FoodaInventory> readByExample(@RequestBody FoodaInventoryDTO dto) {
        return inventoryService.getByExample(dto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Sample inventory NOT found!"));
    }

    @GetMapping("store/{storeId}")
    public ResponseEntity<List<FoodaInventory>> readByStoreId(@PathVariable Long storeId) {
        final List<FoodaInventory> inventories = inventoryService.getByStore(storeId);
        return !inventories.isEmpty()
                ? ResponseEntity.ok(inventories)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("product_and_store")
    public ResponseEntity<List<FoodaInventory>> readByProductAndStore(@RequestParam Long productId, @RequestParam Long storeId) {
        final List<FoodaInventory> inventories = inventoryService.getByProductAndStore(productId, storeId);
        return !inventories.isEmpty()
                ? ResponseEntity.ok(inventories)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FoodaInventory> create(@RequestBody FoodaInventoryDTO dto) {
        return inventoryService.add(dto)
                .map(inventory -> {
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(inventory.getId())
                            .toUri();
                    return ResponseEntity.created(location).body(inventory);
                })
                .orElseThrow(() -> new ResourceAlreadyExistsException("This inventory is already registered."));
    }

    @PutMapping("{id}")
    public ResponseEntity<FoodaInventory> update(@RequestBody FoodaInventoryDTO dto, @PathVariable Long id) {
        return inventoryService.editById(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping
    public ResponseEntity<FoodaInventory> update(@RequestBody FoodaInventoryDTO find, @RequestBody FoodaInventoryDTO update) {
        return inventoryService.editByExample(find, update)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<FoodaInventory> delete(@PathVariable Long id) {
        return inventoryService.removeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping
    public ResponseEntity<FoodaInventory> delete(@RequestBody FoodaInventoryDTO dto) {
        return inventoryService.removeByExample(dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

}
