package be.fooda.backend.payment.service.mapper;

import be.fooda.backend.payment.model.dto.CategoryResponse;
import be.fooda.backend.payment.model.entity.CategoryEntity;
import be.fooda.backend.payment.model.dto.CreateCategoryRequest;
import be.fooda.backend.payment.model.dto.UpdateCategoryRequest;
import org.mapstruct.*;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CategoryMapper {

    CategoryEntity toEntity(CreateCategoryRequest source);

    CategoryEntity toEntity(UpdateCategoryRequest source, @MappingTarget CategoryEntity target);

    CreateCategoryRequest toCreate(CategoryEntity source);

    UpdateCategoryRequest toUpdate(CategoryEntity source, @MappingTarget UpdateCategoryRequest target);

    @Mapping(source = "id", target = "categoryId")
    CategoryResponse toResponse(CategoryEntity source);

}
