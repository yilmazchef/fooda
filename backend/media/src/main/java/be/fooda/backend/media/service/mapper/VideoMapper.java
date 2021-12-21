package be.fooda.backend.media.service.mapper;

import be.fooda.backend.media.model.dto.CreateVideoRequest;
import be.fooda.backend.media.model.dto.UpdateVideoRequest;
import be.fooda.backend.media.model.dto.VideoResponse;
import be.fooda.backend.media.model.entity.VideoEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface VideoMapper {

    VideoEntity toEntity(CreateVideoRequest source);

    VideoEntity toEntity(UpdateVideoRequest source, @MappingTarget VideoEntity target);

    CreateVideoRequest toRequest(VideoEntity source);

    List<CreateVideoRequest> toRequests(List<VideoEntity> sources);

    UpdateVideoRequest toRequest(VideoEntity source, @MappingTarget UpdateVideoRequest target);

    // FIELD_LEVEL_CUSTOMIZATIONS
    VideoResponse toResponse(VideoEntity source);

}
