// @ts-nocheck

import DeliveryStatusModel from './DeliveryStatusModel';
import UpdateDeliveryRequest from './UpdateDeliveryRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.delivery.UpdateDeliveryRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\delivery\UpdateDeliveryRequest.java}
 */
export default class UpdateDeliveryRequestModel<T extends UpdateDeliveryRequest = UpdateDeliveryRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => UpdateDeliveryRequest;

  get note(): StringModel {
    return this[_getPropertyModel]('note', StringModel, [true]);
  }

  get status(): DeliveryStatusModel {
    return this[_getPropertyModel]('status', DeliveryStatusModel, [true]);
  }
}
