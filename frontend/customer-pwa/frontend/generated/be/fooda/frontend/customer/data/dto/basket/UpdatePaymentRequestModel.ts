// @ts-nocheck

import UpdatePaymentRequest from './UpdatePaymentRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.UpdatePaymentRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\UpdatePaymentRequest.java}
 */
export default class UpdatePaymentRequestModel<T extends UpdatePaymentRequest = UpdatePaymentRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => UpdatePaymentRequest;

  get amount(): NumberModel {
    return this[_getPropertyModel]('amount', NumberModel, [true]);
  }

  get isPaid(): BooleanModel {
    return this[_getPropertyModel]('isPaid', BooleanModel, [true]);
  }

  get paymentId(): NumberModel {
    return this[_getPropertyModel]('paymentId', NumberModel, [true]);
  }
}
