// @ts-nocheck

import OrderStatus from './OrderStatus';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.order.OrderStatus.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 */
export default class OrderStatusModel<T extends OrderStatus = OrderStatus> extends ObjectModel<T> { 
  static createEmptyValue: () => OrderStatus;
}
