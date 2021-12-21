package be.fooda.backend.review.service.mapper;

import be.fooda.backend.review.model.document.PaymentDocument;
import be.fooda.backend.review.model.dto.CreatePaymentRequest;
import be.fooda.backend.review.model.dto.PaymentResponse;
import be.fooda.backend.review.model.dto.UpdatePaymentRequest;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface PaymentMapper {

    PaymentDocument toDocument(CreatePaymentRequest source);

    PaymentDocument toDocument(UpdatePaymentRequest source, @MappingTarget PaymentDocument target);

    PaymentResponse toResponse(PaymentDocument source);
}
