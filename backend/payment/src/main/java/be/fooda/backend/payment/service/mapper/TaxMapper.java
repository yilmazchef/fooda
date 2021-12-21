package be.fooda.backend.payment.service.mapper;

import be.fooda.backend.payment.model.dto.CreateTaxRequest;
import be.fooda.backend.payment.model.dto.TaxResponse;
import be.fooda.backend.payment.model.dto.UpdateTaxRequest;
import be.fooda.backend.payment.model.entity.TaxEntity;
import org.mapstruct.*;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface TaxMapper {

    TaxEntity toEntity(CreateTaxRequest source);

    TaxEntity toEntity(UpdateTaxRequest source, @MappingTarget TaxEntity target);

    CreateTaxRequest toCreate(TaxEntity source);

    UpdateTaxRequest toUpdate(TaxEntity source, @MappingTarget UpdateTaxRequest target);

    @Mapping(source = "id", target = "taxId")
    TaxResponse toResponse(TaxEntity source);

}
