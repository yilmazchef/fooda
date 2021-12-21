package be.fooda.backend.product.service.mapper;

import java.util.List;
import java.util.Set;

import be.fooda.backend.product.model.dto.*;
import be.fooda.backend.product.model.entity.*;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    ProductEntity toEntity(CreateProductRequest source);

    ProductEntity toEntity(UpdateProductRequest source, @MappingTarget ProductEntity target);

    CreateProductRequest toRequest(ProductEntity source);

    UpdateProductRequest toRequest(ProductEntity source, @MappingTarget UpdateProductRequest target);

    // FIELD_LEVEL_CUSTOMIZATIONS
    @Mapping(source = "storeId", target = "store.storeId")
    @Mapping(source = "defaultImageId", target = "defaultImage.mediaId")
    @Mapping(source = "id", target = "productId")
    @Mapping(source = "id", target = "ingredients.ingredientId")
    @Mapping(source = "id", target = "categories.categoryId")
    @Mapping(source = "id", target = "tags.tagId")
    @Mapping(source = "id", target = "taxes.taxId")
    ProductResponse toResponse(ProductEntity source);

}
