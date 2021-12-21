// @ts-nocheck

import CustomerClientResponse from './CustomerClientResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.delivery.remote.CustomerClientResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\delivery\remote\CustomerClientResponse.java}
 */
export default class CustomerClientResponseModel<T extends CustomerClientResponse = CustomerClientResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => CustomerClientResponse;

  get customerId(): NumberModel {
    return this[_getPropertyModel]('customerId', NumberModel, [true]);
  }

  get familyName(): StringModel {
    return this[_getPropertyModel]('familyName', StringModel, [true]);
  }

  get firstName(): StringModel {
    return this[_getPropertyModel]('firstName', StringModel, [true]);
  }
}
