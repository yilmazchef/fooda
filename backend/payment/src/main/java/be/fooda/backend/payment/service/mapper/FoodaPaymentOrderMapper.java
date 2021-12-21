package be.fooda.backend.payment.service.mapper;

import be.fooda.backend.commons.model.payment.create.FoodaPaymentOrderCreate;
import be.fooda.backend.commons.model.payment.read.FoodaPaymentOrderExample;
import be.fooda.backend.commons.model.payment.update.FoodaPaymentOrderUpdate;
import be.fooda.backend.payment.model.entity.FoodaPaymentOrder;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FoodaPaymentOrderMapper {

    FoodaPaymentOrder fromCreateToEntity(FoodaPaymentOrderCreate from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPaymentOrder fromUpdateToEntity(FoodaPaymentOrderUpdate from, @MappingTarget FoodaPaymentOrder to);

    FoodaPaymentOrder fromExampleToEntity(FoodaPaymentOrderExample from);

    FoodaPaymentOrderCreate fromEntityToCreate(FoodaPaymentOrder from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPaymentOrderUpdate fromEntityToUpdate(FoodaPaymentOrder from, @MappingTarget FoodaPaymentOrderUpdate to);

    FoodaPaymentOrderExample fromEntityToExample(FoodaPaymentOrder from);
}
