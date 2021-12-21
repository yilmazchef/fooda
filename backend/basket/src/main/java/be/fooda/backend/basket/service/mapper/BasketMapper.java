package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.document.BasketDocument;
import be.fooda.backend.basket.model.dto.BasketResponse;
import be.fooda.backend.basket.model.dto.CreateBasketRequest;
import be.fooda.backend.basket.model.dto.UpdateBasketRequest;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface BasketMapper {

    BasketDocument toDocument(CreateBasketRequest source);
    BasketDocument toDocument(UpdateBasketRequest source, @MappingTarget BasketDocument target);
    BasketResponse toResponse(BasketDocument source);
    List<BasketResponse> toResponses(List<BasketDocument> source);
}
