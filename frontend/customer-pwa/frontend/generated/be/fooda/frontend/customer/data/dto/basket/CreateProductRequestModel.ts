// @ts-nocheck

import CreateMediaRequestModel from './CreateMediaRequestModel';
import CreateProductRequest from './CreateProductRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.CreateProductRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\CreateProductRequest.java}
 */
export default class CreateProductRequestModel<T extends CreateProductRequest = CreateProductRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateProductRequest;

  get discount(): NumberModel {
    return this[_getPropertyModel]('discount', NumberModel, [true]);
  }

  get media(): CreateMediaRequestModel {
    return this[_getPropertyModel]('media', CreateMediaRequestModel, [true]);
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

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }
}