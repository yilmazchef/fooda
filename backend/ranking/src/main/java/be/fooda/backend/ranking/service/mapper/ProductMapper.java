package be.fooda.backend.ranking.service.mapper;

import be.fooda.backend.ranking.model.document.ProductDocument;
import be.fooda.backend.ranking.model.dto.CreateProductRequest;
import be.fooda.backend.ranking.model.dto.ProductResponse;
import be.fooda.backend.ranking.model.dto.UpdateProductRequest;
import org.mapstruct.*;

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
