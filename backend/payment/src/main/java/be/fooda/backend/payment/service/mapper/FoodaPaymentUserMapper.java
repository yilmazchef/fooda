package be.fooda.backend.payment.service.mapper;

import be.fooda.backend.commons.model.payment.create.FoodaPaymentUserCreate;
import be.fooda.backend.commons.model.payment.read.FoodaPaymentUserExample;
import be.fooda.backend.commons.model.payment.update.FoodaPaymentUserUpdate;
import be.fooda.backend.payment.model.entity.FoodaPaymentUser;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FoodaPaymentUserMapper {

    FoodaPaymentUser fromCreateToEntity(FoodaPaymentUserCreate from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPaymentUser fromUpdateToEntity(FoodaPaymentUserUpdate from, @MappingTarget FoodaPaymentUser to);

    FoodaPaymentUser fromExampleToEntity(FoodaPaymentUserExample from);

    FoodaPaymentUserCreate fromEntityToCreate(FoodaPaymentUser from);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FoodaPaymentUserUpdate fromEntityToUpdate(FoodaPaymentUser from, @MappingTarget FoodaPaymentUserUpdate to);

    FoodaPaymentUserExample fromEntityToExample(FoodaPaymentUser from);
}
