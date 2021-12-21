package be.fooda.backend.payment.service.mapper;

import be.fooda.backend.commons.model.payment.create.FoodaPaymentItemCreate;
import be.fooda.backend.commons.model.payment.read.FoodaPaymentItemExample;
import be.fooda.backend.commons.model.payment.update.FoodaPaymentItemUpdate;
import be.fooda.backend.payment.model.entity.FoodaPaymentItem;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FoodaPaymentItemMapper {

    FoodaPaymentItem fromCreateToEntity(FoodaPaymentItemCreate from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPaymentItem fromUpdateToEntity(FoodaPaymentItemUpdate from, @MappingTarget FoodaPaymentItem to);

    FoodaPaymentItem fromExampleToEntity(FoodaPaymentItemExample from);

    FoodaPaymentItem fromEntityToCreate(FoodaPaymentItemCreate from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPaymentItem fromEntityToUpdate(FoodaPaymentItemUpdate from, @MappingTarget FoodaPaymentItem to);

    FoodaPaymentItem fromEntityToExample(FoodaPaymentItemExample from);
}
