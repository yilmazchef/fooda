// @ts-nocheck

import PriceResponse from './PriceResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.PriceResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\PriceResponse.java}
 */
export default class PriceResponseModel<T extends PriceResponse = PriceResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => PriceResponse;

  get amount(): NumberModel {
    return this[_getPropertyModel]('amount', NumberModel, [true]);
  }

  get currency(): StringModel {
    return this[_getPropertyModel]('currency', StringModel, [true]);
  }

  get expiresAt(): StringModel {
    return this[_getPropertyModel]('expiresAt', StringModel, [true]);
  }

  get isDefault(): BooleanModel {
    return this[_getPropertyModel]('isDefault', BooleanModel, [true]);
  }

  get priceId(): NumberModel {
    return this[_getPropertyModel]('priceId', NumberModel, [true]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }
}
