// @ts-nocheck

import StoreResponse from './StoreResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.StoreResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\StoreResponse.java}
 */
export default class StoreResponseModel<T extends StoreResponse = StoreResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => StoreResponse;

  get storeId(): NumberModel {
    return this[_getPropertyModel]('storeId', NumberModel, [true]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }
}