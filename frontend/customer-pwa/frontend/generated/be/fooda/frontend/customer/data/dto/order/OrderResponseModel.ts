// @ts-nocheck

import CustomerResponseModel from './CustomerResponseModel';
import DeliveryResponseModel from './DeliveryResponseModel';
import OrderStatusModel from './OrderStatusModel';
import PaymentResponseModel from './PaymentResponseModel';
import ProductResponseModel from './ProductResponseModel';
import StoreResponseModel from './StoreResponseModel';
import OrderResponse from './OrderResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.order.OrderResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\order\OrderResponse.java}
 */
export default class OrderResponseModel<T extends OrderResponse = OrderResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => OrderResponse;

  get createdAt(): StringModel {
    return this[_getPropertyModel]('createdAt', StringModel, [true]);
  }

  get customer(): CustomerResponseModel {
    return this[_getPropertyModel]('customer', CustomerResponseModel, [true]);
  }

  get deliveredAt(): StringModel {
    return this[_getPropertyModel]('deliveredAt', StringModel, [true]);
  }

  get delivery(): DeliveryResponseModel {
    return this[_getPropertyModel]('delivery', DeliveryResponseModel, [true]);
  }

  get deliveryTotal(): NumberModel {
    return this[_getPropertyModel]('deliveryTotal', NumberModel, [true]);
  }

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
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

  get payments(): ArrayModel<ModelType<PaymentResponseModel>, PaymentResponseModel> {
    return this[_getPropertyModel]('payments', ArrayModel, [true, PaymentResponseModel, [true]]);
  }

  get priceTotal(): NumberModel {
    return this[_getPropertyModel]('priceTotal', NumberModel, [true]);
  }

  get products(): ArrayModel<ModelType<ProductResponseModel>, ProductResponseModel> {
    return this[_getPropertyModel]('products', ArrayModel, [true, ProductResponseModel, [true]]);
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

  get store(): StoreResponseModel {
    return this[_getPropertyModel]('store', StoreResponseModel, [true]);
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
