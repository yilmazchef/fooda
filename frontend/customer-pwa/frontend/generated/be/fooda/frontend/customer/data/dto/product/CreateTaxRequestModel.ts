// @ts-nocheck

import CreateTaxRequest from './CreateTaxRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.CreateTaxRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\CreateTaxRequest.java}
 */
export default class CreateTaxRequestModel<T extends CreateTaxRequest = CreateTaxRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateTaxRequest;

  get isDefault(): BooleanModel {
    return this[_getPropertyModel]('isDefault', BooleanModel, [true]);
  }

  get percentage(): NumberModel {
    return this[_getPropertyModel]('percentage', NumberModel, [true]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }
}
