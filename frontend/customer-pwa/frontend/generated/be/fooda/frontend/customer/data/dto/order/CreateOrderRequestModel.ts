// @ts-nocheck

import OrderStatusModel from './OrderStatusModel';
import CreateOrderRequest from './CreateOrderRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.order.CreateOrderRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\order\CreateOrderRequest.java}
 */
export default class CreateOrderRequestModel<T extends CreateOrderRequest = CreateOrderRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateOrderRequest;

  get createdAt(): StringModel {
    return this[_getPropertyModel]('createdAt', StringModel, [true]);
  }

  get customerId(): NumberModel {
    return this[_getPropertyModel]('customerId', NumberModel, [true]);
  }

  get deliveredAt(): StringModel {
    return this[_getPropertyModel]('deliveredAt', StringModel, [true]);
  }

  get deliveryId(): NumberModel {
    return this[_getPropertyModel]('deliveryId', NumberModel, [true]);
  }

  get deliveryTotal(): NumberModel {
    return this[_getPropertyModel]('deliveryTotal', NumberModel, [true]);
  }

  get isActive(): BooleanModel {
    return this[_getPropertyModel]('isActive', BooleanModel, [true]);
  }

  get note(): StringModel {
    return this[_getPropertyModel]('note', StringModel, [true]);
  }

  get paymentAt(): StringModel {
    return this[_getPropertyModel]('paymentAt', StringModel, [true]);
  }

  get payments(): ArrayModel<number, NumberModel> {
    return this[_getPropertyModel]('payments', ArrayModel, [true, NumberModel, [true]]);
  }

  get priceTotal(): NumberModel {
    return this[_getPropertyModel]('priceTotal', NumberModel, [true]);
  }

  get products(): ArrayModel<number, NumberModel> {
    return this[_getPropertyModel]('products', ArrayModel, [true, NumberModel, [true]]);
  }

  get productsTotal(): NumberModel {
    return this[_getPropertyModel]('productsTotal', NumberModel, [true]);
  }

  get requiredAt(): StringModel {
    return this[_getPropertyModel]('requiredAt', StringModel, [true]);
  }

  get status(): OrderStatusModel {
    return this[_getPropertyModel]('status', OrderStatusModel, [true]);
  }

  get storeId(): NumberModel {
    return this[_getPropertyModel]('storeId', NumberModel, [true]);
  }

  get taxTotal(): NumberModel {
    return this[_getPropertyModel]('taxTotal', NumberModel, [true]);
  }

  get trackingId(): StringModel {
    return this[_getPropertyModel]('trackingId', StringModel, [true]);
  }

  get updatedAt(): StringModel {
    return this[_getPropertyModel]('updatedAt', StringModel, [true]);
  }
}
