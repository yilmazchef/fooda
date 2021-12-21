package be.fooda.backend.ranking.service.mapper;

import be.fooda.backend.ranking.model.document.CustomerDocument;
import be.fooda.backend.ranking.model.dto.CreateCustomerRequest;
import be.fooda.backend.ranking.model.dto.CustomerResponse;
import be.fooda.backend.ranking.model.dto.UpdateCustomerRequest;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface CustomerMapper {

    CustomerDocument toDocument(CreateCustomerRequest source);

    CustomerDocument toDocument(UpdateCustomerRequest source, @MappingTarget CustomerDocument target);

    CustomerResponse toResponse(CustomerDocument source);
}
