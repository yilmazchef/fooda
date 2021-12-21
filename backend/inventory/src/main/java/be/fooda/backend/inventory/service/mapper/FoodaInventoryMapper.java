package be.fooda.backend.inventory.service.mapper;

import be.fooda.backend.inventory.model.dto.FoodaInventoryDTO;
import be.fooda.backend.inventory.model.entity.FoodaInventory;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodaInventoryMapper {

    FoodaInventoryDTO toDTO(FoodaInventory source);

    FoodaInventory toEntity(FoodaInventoryDTO source);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaInventoryDTO toDTO(FoodaInventory source, @MappingTarget FoodaInventoryDTO existing);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaInventory toEntity(FoodaInventoryDTO source, @MappingTarget FoodaInventory existing);

    List<FoodaInventoryDTO> toDTO(List<FoodaInventory> source);

    List<FoodaInventory> toEntity(List<FoodaInventoryDTO> source);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<FoodaInventoryDTO> toDTO(List<FoodaInventory> source, @MappingTarget List<FoodaInventoryDTO> existing);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    List<FoodaInventoryDTO> toEntity(List<FoodaInventory> source, @MappingTarget List<FoodaInventoryDTO> existing);

}
