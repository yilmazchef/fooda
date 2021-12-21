package be.fooda.backend.payment.service.mapper;

import be.fooda.backend.commons.model.payment.create.FoodaPaymentCreate;
import be.fooda.backend.commons.model.payment.read.FoodaPaymentExample;
import be.fooda.backend.commons.model.payment.update.FoodaPaymentUpdate;
import be.fooda.backend.payment.model.entity.FoodaPayment;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FoodaPaymentMapper {

    FoodaPayment fromCreateToEntity(FoodaPaymentCreate from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPayment fromUpdateToEntity(FoodaPaymentUpdate from, @MappingTarget FoodaPayment to);

    FoodaPayment fromExampleToEntity(FoodaPaymentExample from);

    FoodaPaymentCreate fromEntityToCreate(FoodaPayment from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPaymentUpdate fromEntityToUpdate(FoodaPayment from, @MappingTarget FoodaPaymentUpdate to);

    FoodaPaymentExample fromEntityToExample(FoodaPayment from);

}
