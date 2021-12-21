// @ts-nocheck

import UpdateProductRequest from './UpdateProductRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.UpdateProductRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\UpdateProductRequest.java}
 */
export default class UpdateProductRequestModel<T extends UpdateProductRequest = UpdateProductRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => UpdateProductRequest;

  get discount(): NumberModel {
    return this[_getPropertyModel]('discount', NumberModel, [true]);
  }

  get price(): NumberModel {
    return this[_getPropertyModel]('price', NumberModel, [true]);
  }

  get productId(): NumberModel {
    return this[_getPropertyModel]('productId', NumberModel, [true]);
  }

  get quantity(): NumberModel {
    return this[_getPropertyModel]('quantity', NumberModel, [true]);
  }
}
