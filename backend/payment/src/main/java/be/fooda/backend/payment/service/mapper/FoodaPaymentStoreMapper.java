package be.fooda.backend.payment.service.mapper;

import be.fooda.backend.commons.model.payment.create.FoodaPaymentStoreCreate;
import be.fooda.backend.commons.model.payment.read.FoodaPaymentStoreExample;
import be.fooda.backend.commons.model.payment.update.FoodaPaymentStoreUpdate;
import be.fooda.backend.payment.model.entity.FoodaPaymentStore;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FoodaPaymentStoreMapper {

    FoodaPaymentStore fromCreateToEntity(FoodaPaymentStoreCreate from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPaymentStore fromUpdateToEntity(FoodaPaymentStoreUpdate from, @MappingTarget FoodaPaymentStore to);

    FoodaPaymentStore fromExampleToEntity(FoodaPaymentStoreExample from);

    FoodaPaymentStoreCreate fromEntityToCreate(FoodaPaymentStore from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPaymentStoreUpdate fromEntityToUpdate(FoodaPaymentStore from, @MappingTarget FoodaPaymentStoreUpdate to);

    FoodaPaymentStoreExample fromEntityToExample(FoodaPaymentStore from);
}
