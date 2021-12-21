// @ts-nocheck

import CustomerResponseModel from './CustomerResponseModel';
import ProductResponseModel from './ProductResponseModel';
import StoreResponseModel from './StoreResponseModel';
import BasketResponse from './BasketResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.BasketResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\BasketResponse.java}
 */
export default class BasketResponseModel<T extends BasketResponse = BasketResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => BasketResponse;

  get customer(): CustomerResponseModel {
    return this[_getPropertyModel]('customer', CustomerResponseModel, [true]);
  }

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
  }

  get products(): ArrayModel<ModelType<ProductResponseModel>, ProductResponseModel> {
    return this[_getPropertyModel]('products', ArrayModel, [true, ProductResponseModel, [true]]);
  }

  get session(): StringModel {
    return this[_getPropertyModel]('session', StringModel, [true]);
  }

  get store(): StoreResponseModel {
    return this[_getPropertyModel]('store', StoreResponseModel, [true]);
  }

  get totalPrice(): NumberModel {
    return this[_getPropertyModel]('totalPrice', NumberModel, [true]);
  }
}
