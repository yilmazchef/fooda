package be.fooda.backend.ranking.service.mapper;

import be.fooda.backend.ranking.model.document.PaymentDocument;
import be.fooda.backend.ranking.model.dto.CreatePaymentRequest;
import be.fooda.backend.ranking.model.dto.PaymentResponse;
import be.fooda.backend.ranking.model.dto.UpdatePaymentRequest;
import org.mapstruct.*;

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
