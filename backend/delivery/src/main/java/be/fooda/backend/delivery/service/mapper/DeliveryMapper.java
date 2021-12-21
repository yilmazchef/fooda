package be.fooda.backend.delivery.service.mapper;

import be.fooda.backend.delivery.model.dto.CreateDeliveryRequest;
import be.fooda.backend.delivery.model.dto.DeliveryResponse;
import be.fooda.backend.delivery.model.dto.UpdateDeliveryRequest;
import be.fooda.backend.delivery.model.entity.DeliveryEntity;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DeliveryMapper {

    DeliveryEntity toEntity(CreateDeliveryRequest source);

    DeliveryEntity toEntity(UpdateDeliveryRequest source, @MappingTarget DeliveryEntity target);

    CreateDeliveryRequest toCreate(DeliveryEntity source);

    UpdateDeliveryRequest toUpdate(DeliveryEntity source, @MappingTarget UpdateDeliveryRequest target);

    DeliveryResponse toResponse(DeliveryEntity source);

    List<DeliveryResponse> toResponses(List<DeliveryEntity> source);
}
