// @ts-nocheck

import AddressResponse from './AddressResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.customer.AddressResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\customer\AddressResponse.java}
 */
export default class AddressResponseModel<T extends AddressResponse = AddressResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => AddressResponse;

  get addressId(): NumberModel {
    return this[_getPropertyModel]('addressId', NumberModel, [true]);
  }

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
  }

  get isDefault(): BooleanModel {
    return this[_getPropertyModel]('isDefault', BooleanModel, [true]);
  }

  get municipality(): StringModel {
    return this[_getPropertyModel]('municipality', StringModel, [true]);
  }

  get postcode(): StringModel {
    return this[_getPropertyModel]('postcode', StringModel, [true]);
  }
}
