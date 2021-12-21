package be.fooda.backend.payment.service.mapper;

import java.util.List;
import java.util.Set;

import be.fooda.backend.payment.model.dto.*;
import be.fooda.backend.payment.model.entity.*;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentMapper {

    PaymentEntity toEntity(CreatePaymentRequest source);

    PaymentEntity toEntity(UpdatePaymentRequest source, @MappingTarget PaymentEntity target);

    CreatePaymentRequest toRequest(PaymentEntity source);

    UpdatePaymentRequest toRequest(PaymentEntity source, @MappingTarget UpdatePaymentRequest target);

    // FIELD_LEVEL_CUSTOMIZATIONS
    @Mapping(source = "storeId", target = "store.storeId")
    @Mapping(source = "defaultImageId", target = "defaultImage.mediaId")
    @Mapping(source = "id", target = "paymentId")
    @Mapping(source = "id", target = "ingredients.ingredientId")
    @Mapping(source = "id", target = "categories.categoryId")
    @Mapping(source = "id", target = "tags.tagId")
    @Mapping(source = "id", target = "taxes.taxId")
    PaymentResponse toResponse(PaymentEntity source);

}
