// @ts-nocheck

import ProductResponse from './ProductResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.order.ProductResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\order\ProductResponse.java}
 */
export default class ProductResponseModel<T extends ProductResponse = ProductResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => ProductResponse;

  get price(): NumberModel {
    return this[_getPropertyModel]('price', NumberModel, [true]);
  }

  get productId(): NumberModel {
    return this[_getPropertyModel]('productId', NumberModel, [true]);
  }

  get productName(): StringModel {
    return this[_getPropertyModel]('productName', StringModel, [true]);
  }

  get quantity(): NumberModel {
    return this[_getPropertyModel]('quantity', NumberModel, [true]);
  }

  get tax(): NumberModel {
    return this[_getPropertyModel]('tax', NumberModel, [true]);
  }
}
