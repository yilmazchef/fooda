package be.fooda.backend.courier.service.mapper;

import be.fooda.backend.courier.model.dto.VehicleResponse;
import be.fooda.backend.courier.model.dto.CreateVehicleRequest;
import be.fooda.backend.courier.model.dto.UpdateVehicleRequest;
import be.fooda.backend.courier.model.entity.VehicleEntity;
import org.mapstruct.*;

@Mapper(
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface VehicleMapper {

    VehicleEntity toEntity(CreateVehicleRequest source);

    VehicleEntity toEntity(UpdateVehicleRequest source, @MappingTarget VehicleEntity target);

    CreateVehicleRequest toCreate(VehicleEntity source);

    UpdateVehicleRequest toUpdate(VehicleEntity source, @MappingTarget UpdateVehicleRequest target);

    @Mapping(source = "id", target = "vehicleId")
    VehicleResponse toResponse(VehicleEntity source);

}
