// @ts-nocheck

import UpdatePaymentRequestModel from './UpdatePaymentRequestModel';
import UpdateProductRequestModel from './UpdateProductRequestModel';
import UpdateBasketRequest from './UpdateBasketRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.UpdateBasketRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\UpdateBasketRequest.java}
 */
export default class UpdateBasketRequestModel<T extends UpdateBasketRequest = UpdateBasketRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => UpdateBasketRequest;

  get payments(): ArrayModel<ModelType<UpdatePaymentRequestModel>, UpdatePaymentRequestModel> {
    return this[_getPropertyModel]('payments', ArrayModel, [true, UpdatePaymentRequestModel, [true]]);
  }

  get products(): ArrayModel<ModelType<UpdateProductRequestModel>, UpdateProductRequestModel> {
    return this[_getPropertyModel]('products', ArrayModel, [true, UpdateProductRequestModel, [true]]);
  }
}
