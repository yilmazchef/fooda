package be.fooda.backend.review.service.mapper;

import be.fooda.backend.review.model.document.ProductDocument;
import be.fooda.backend.review.model.dto.CreateProductRequest;
import be.fooda.backend.review.model.dto.ProductResponse;
import be.fooda.backend.review.model.dto.UpdateProductRequest;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface ProductMapper {

    ProductDocument toDocument(CreateProductRequest source);

    ProductDocument toDocument(UpdateProductRequest source, @MappingTarget ProductDocument target);

    ProductResponse toResponse(ProductDocument source);
}
