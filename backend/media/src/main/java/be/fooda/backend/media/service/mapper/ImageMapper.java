package be.fooda.backend.media.service.mapper;

import be.fooda.backend.media.model.dto.CreateImageRequest;
import be.fooda.backend.media.model.dto.ImageResponse;
import be.fooda.backend.media.model.dto.UpdateImageRequest;
import be.fooda.backend.media.model.entity.ImageEntity;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ImageMapper {

    ImageEntity toEntity(CreateImageRequest source);

    ImageEntity toEntity(UpdateImageRequest source, @MappingTarget ImageEntity target);

    CreateImageRequest toRequest(ImageEntity source);

    UpdateImageRequest toRequest(ImageEntity source, @MappingTarget UpdateImageRequest target);

    // FIELD_LEVEL_CUSTOMIZATIONS
    ImageResponse toResponse(ImageEntity source);

}
