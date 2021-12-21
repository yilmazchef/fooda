// @ts-nocheck

import PaymentResponse from './PaymentResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.customer.PaymentResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\customer\PaymentResponse.java}
 */
export default class PaymentResponseModel<T extends PaymentResponse = PaymentResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => PaymentResponse;

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
  }

  get isDefault(): BooleanModel {
    return this[_getPropertyModel]('isDefault', BooleanModel, [true]);
  }

  get method(): StringModel {
    return this[_getPropertyModel]('method', StringModel, [true]);
  }

  get paymentId(): NumberModel {
    return this[_getPropertyModel]('paymentId', NumberModel, [true]);
  }
}
