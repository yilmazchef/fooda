// @ts-nocheck

import CourierClientResponse from './CourierClientResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.delivery.remote.CourierClientResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\delivery\remote\CourierClientResponse.java}
 */
export default class CourierClientResponseModel<T extends CourierClientResponse = CourierClientResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => CourierClientResponse;

  get courierId(): NumberModel {
    return this[_getPropertyModel]('courierId', NumberModel, [true]);
  }

  get familyName(): StringModel {
    return this[_getPropertyModel]('familyName', StringModel, [true]);
  }

  get firstName(): StringModel {
    return this[_getPropertyModel]('firstName', StringModel, [true]);
  }
}
