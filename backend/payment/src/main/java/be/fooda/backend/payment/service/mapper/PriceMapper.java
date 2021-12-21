package be.fooda.backend.payment.service.mapper;

import be.fooda.backend.payment.model.dto.CreatePriceRequest;
import be.fooda.backend.payment.model.dto.PriceResponse;
import be.fooda.backend.payment.model.dto.UpdatePriceRequest;
import be.fooda.backend.payment.model.entity.PriceEntity;
import org.mapstruct.*;

import java.util.Set;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PriceMapper {

    PriceEntity toEntity(CreatePriceRequest source);

    PriceEntity toEntity(UpdatePriceRequest source, @MappingTarget PriceEntity target);

    CreatePriceRequest toCreate(PriceEntity source);

    UpdatePriceRequest toUpdate(PriceEntity source, @MappingTarget UpdatePriceRequest target);

    @Mapping(source = "id", target = "priceId")
    PriceResponse toResponse(PriceEntity source);

}
