package be.fooda.backend.review.service.mapper;

import be.fooda.backend.review.model.document.CustomerDocument;
import be.fooda.backend.review.model.dto.CreateCustomerRequest;
import be.fooda.backend.review.model.dto.CustomerResponse;
import be.fooda.backend.review.model.dto.UpdateCustomerRequest;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

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
