package be.fooda.backend.address.service.mapper;

import be.fooda.backend.address.model.dto.AddressResponse;
import be.fooda.backend.address.model.dto.CreateAddressRequest;
import be.fooda.backend.address.model.dto.UpdateAddressRequest;
import be.fooda.backend.address.model.entity.AddressEntity;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    AddressEntity toEntity(CreateAddressRequest source);

    AddressEntity toEntity(UpdateAddressRequest source, @MappingTarget AddressEntity target);

    CreateAddressRequest toRequest(AddressEntity source);

    // FIELD_LEVEL_CUSTOMIZATIONS
    @Mapping(source = "userId", target = "user.userId")
    @Mapping(source = "id", target = "addressId")
    AddressResponse toResponse(AddressEntity source);


}
