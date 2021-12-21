// @ts-nocheck

import OrderResponse from './OrderResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.customer.OrderResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\customer\OrderResponse.java}
 */
export default class OrderResponseModel<T extends OrderResponse = OrderResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => OrderResponse;

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
  }

  get note(): StringModel {
    return this[_getPropertyModel]('note', StringModel, [true]);
  }

  get orderId(): NumberModel {
    return this[_getPropertyModel]('orderId', NumberModel, [true]);
  }
}
