package be.fooda.backend.contact.service.mapper;

import be.fooda.backend.contact.model.dto.ContactResponse;
import be.fooda.backend.contact.model.dto.CreateContactRequest;
import be.fooda.backend.contact.model.dto.UpdateContactRequest;
import be.fooda.backend.contact.model.entity.ContactEntity;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContactMapper {

    ContactEntity toEntity(CreateContactRequest source);

    ContactEntity toEntity(UpdateContactRequest source, @MappingTarget ContactEntity target);

    CreateContactRequest toRequest(ContactEntity source);

    UpdateContactRequest toRequest(ContactEntity source, @MappingTarget UpdateContactRequest target);

    // FIELD_LEVEL_CUSTOMIZATIONS
    @Mapping(source = "userId", target = "user.userId")
    @Mapping(source = "id", target = "contactId")
    ContactResponse toResponse(ContactEntity source);

}
