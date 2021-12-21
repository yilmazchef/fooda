package be.fooda.backend.review.service.mapper;

import be.fooda.backend.review.model.document.StoreDocument;
import be.fooda.backend.review.model.dto.CreateStoreRequest;
import be.fooda.backend.review.model.dto.StoreResponse;
import be.fooda.backend.review.model.dto.UpdateStoreRequest;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface StoreMapper {

    StoreDocument toDocument(CreateStoreRequest source);

    StoreDocument toDocument(UpdateStoreRequest source, @MappingTarget StoreDocument target);

    StoreResponse toResponse(StoreDocument source);
}
