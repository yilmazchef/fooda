package be.fooda.backend.ranking.service.mapper;

import be.fooda.backend.ranking.model.document.StoreDocument;
import be.fooda.backend.ranking.model.dto.CreateStoreRequest;
import be.fooda.backend.ranking.model.dto.StoreResponse;
import be.fooda.backend.ranking.model.dto.UpdateStoreRequest;
import org.mapstruct.*;

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
