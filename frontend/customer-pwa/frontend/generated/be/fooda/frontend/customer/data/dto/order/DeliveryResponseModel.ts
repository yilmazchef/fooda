// @ts-nocheck

import OrderStatusModel from './OrderStatusModel';
import DeliveryResponse from './DeliveryResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.order.DeliveryResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\order\DeliveryResponse.java}
 */
export default class DeliveryResponseModel<T extends DeliveryResponse = DeliveryResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => DeliveryResponse;

  get cost(): NumberModel {
    return this[_getPropertyModel]('cost', NumberModel, [true]);
  }

  get deliveryId(): NumberModel {
    return this[_getPropertyModel]('deliveryId', NumberModel, [true]);
  }

  get status(): OrderStatusModel {
    return this[_getPropertyModel]('status', OrderStatusModel, [true]);
  }
}
