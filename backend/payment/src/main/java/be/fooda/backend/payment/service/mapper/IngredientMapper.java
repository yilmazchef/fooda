package be.fooda.backend.payment.service.mapper;

import be.fooda.backend.payment.model.dto.CreateIngredientRequest;
import be.fooda.backend.payment.model.dto.IngredientResponse;
import be.fooda.backend.payment.model.dto.UpdateIngredientRequest;
import be.fooda.backend.payment.model.entity.IngredientEntity;
import org.mapstruct.*;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface IngredientMapper {

    IngredientEntity toEntity(CreateIngredientRequest source);

    IngredientEntity toEntity(UpdateIngredientRequest source, @MappingTarget IngredientEntity target);

    CreateIngredientRequest toCreate(IngredientEntity source);

    UpdateIngredientRequest toUpdate(IngredientEntity source, @MappingTarget UpdateIngredientRequest target);

    @Mapping(source = "id", target = "ingredientId")
    IngredientResponse toResponse(IngredientEntity source);
}
