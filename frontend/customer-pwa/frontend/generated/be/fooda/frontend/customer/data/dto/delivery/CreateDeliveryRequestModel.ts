// @ts-nocheck

import DeliveryStatusModel from './DeliveryStatusModel';
import CreateDeliveryRequest from './CreateDeliveryRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.delivery.CreateDeliveryRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\delivery\CreateDeliveryRequest.java}
 */
export default class CreateDeliveryRequestModel<T extends CreateDeliveryRequest = CreateDeliveryRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateDeliveryRequest;

  get courierId(): NumberModel {
    return this[_getPropertyModel]('courierId', NumberModel, [true]);
  }

  get customerId(): NumberModel {
    return this[_getPropertyModel]('customerId', NumberModel, [true]);
  }

  get deliveredAt(): StringModel {
    return this[_getPropertyModel]('deliveredAt', StringModel, [true]);
  }

  get note(): StringModel {
    return this[_getPropertyModel]('note', StringModel, [true]);
  }

  get orderId(): NumberModel {
    return this[_getPropertyModel]('orderId', NumberModel, [true]);
  }

  get requestedAt(): StringModel {
    return this[_getPropertyModel]('requestedAt', StringModel, [true]);
  }

  get status(): DeliveryStatusModel {
    return this[_getPropertyModel]('status', DeliveryStatusModel, [true]);
  }

  get storeId(): NumberModel {
    return this[_getPropertyModel]('storeId', NumberModel, [true]);
  }

  get trackingId(): StringModel {
    return this[_getPropertyModel]('trackingId', StringModel, [true]);
  }
}
