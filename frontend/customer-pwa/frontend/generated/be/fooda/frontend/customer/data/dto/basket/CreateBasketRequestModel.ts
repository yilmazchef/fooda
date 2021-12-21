// @ts-nocheck

import CreateCustomerRequestModel from './CreateCustomerRequestModel';
import CreateProductRequestModel from './CreateProductRequestModel';
import CreateStoreRequestModel from './CreateStoreRequestModel';
import CreateBasketRequest from './CreateBasketRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.CreateBasketRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\CreateBasketRequest.java}
 */
export default class CreateBasketRequestModel<T extends CreateBasketRequest = CreateBasketRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateBasketRequest;

  get customer(): CreateCustomerRequestModel {
    return this[_getPropertyModel]('customer', CreateCustomerRequestModel, [true]);
  }

  get products(): ArrayModel<ModelType<CreateProductRequestModel>, CreateProductRequestModel> {
    return this[_getPropertyModel]('products', ArrayModel, [true, CreateProductRequestModel, [true]]);
  }

  get session(): StringModel {
    return this[_getPropertyModel]('session', StringModel, [true]);
  }

  get store(): CreateStoreRequestModel {
    return this[_getPropertyModel]('store', CreateStoreRequestModel, [true]);
  }
}
