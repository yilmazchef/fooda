// @ts-nocheck

import OrderClientResponse from './OrderClientResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.delivery.remote.OrderClientResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\delivery\remote\OrderClientResponse.java}
 */
export default class OrderClientResponseModel<T extends OrderClientResponse = OrderClientResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => OrderClientResponse;

  get deliveryTotal(): NumberModel {
    return this[_getPropertyModel]('deliveryTotal', NumberModel, [true]);
  }

  get orderId(): NumberModel {
    return this[_getPropertyModel]('orderId', NumberModel, [true]);
  }

  get priceTotal(): NumberModel {
    return this[_getPropertyModel]('priceTotal', NumberModel, [true]);
  }

  get productsTotal(): NumberModel {
    return this[_getPropertyModel]('productsTotal', NumberModel, [true]);
  }

  get taxTotal(): NumberModel {
    return this[_getPropertyModel]('taxTotal', NumberModel, [true]);
  }

  get trackingId(): NumberModel {
    return this[_getPropertyModel]('trackingId', NumberModel, [true]);
  }
}
