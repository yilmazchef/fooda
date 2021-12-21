package be.fooda.backend.courier.service.mapper;

import be.fooda.backend.courier.model.dto.*;
import be.fooda.backend.courier.model.entity.*;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CourierMapper {

    CourierEntity toEntity(CreateCourierRequest source);

    CourierEntity toEntity(UpdateCourierRequest source, @MappingTarget CourierEntity target);

    CreateCourierRequest toRequest(CourierEntity source);

    UpdateCourierRequest toRequest(CourierEntity source, @MappingTarget UpdateCourierRequest target);

    @Mapping(source = "id", target = "courierId")
    CourierResponse toResponse(CourierEntity source);

}
