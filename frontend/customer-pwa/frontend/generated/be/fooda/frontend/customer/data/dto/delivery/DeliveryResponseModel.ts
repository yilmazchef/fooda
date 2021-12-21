// @ts-nocheck

import DeliveryStatusModel from './DeliveryStatusModel';
import CourierClientResponseModel from './remote/CourierClientResponseModel';
import CustomerClientResponseModel from './remote/CustomerClientResponseModel';
import OrderClientResponseModel from './remote/OrderClientResponseModel';
import StoreClientResponseModel from './remote/StoreClientResponseModel';
import DeliveryResponse from './DeliveryResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.delivery.DeliveryResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\delivery\DeliveryResponse.java}
 */
export default class DeliveryResponseModel<T extends DeliveryResponse = DeliveryResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => DeliveryResponse;

  get courier(): CourierClientResponseModel {
    return this[_getPropertyModel]('courier', CourierClientResponseModel, [true]);
  }

  get customer(): CustomerClientResponseModel {
    return this[_getPropertyModel]('customer', CustomerClientResponseModel, [true]);
  }

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
  }

  get note(): StringModel {
    return this[_getPropertyModel]('note', StringModel, [true]);
  }

  get order(): OrderClientResponseModel {
    return this[_getPropertyModel]('order', OrderClientResponseModel, [true]);
  }

  get status(): DeliveryStatusModel {
    return this[_getPropertyModel]('status', DeliveryStatusModel, [true]);
  }

  get store(): StoreClientResponseModel {
    return this[_getPropertyModel]('store', StoreClientResponseModel, [true]);
  }

  get trackingId(): StringModel {
    return this[_getPropertyModel]('trackingId', StringModel, [true]);
  }
}
