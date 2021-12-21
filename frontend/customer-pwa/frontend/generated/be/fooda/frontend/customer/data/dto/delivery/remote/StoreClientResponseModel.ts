// @ts-nocheck

import StoreClientResponse from './StoreClientResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.delivery.remote.StoreClientResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\delivery\remote\StoreClientResponse.java}
 */
export default class StoreClientResponseModel<T extends StoreClientResponse = StoreClientResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => StoreClientResponse;

  get about(): StringModel {
    return this[_getPropertyModel]('about', StringModel, [true]);
  }

  get bgImageId(): NumberModel {
    return this[_getPropertyModel]('bgImageId', NumberModel, [true]);
  }

  get eTrackingId(): NumberModel {
    return this[_getPropertyModel]('eTrackingId', NumberModel, [true]);
  }

  get isActive(): BooleanModel {
    return this[_getPropertyModel]('isActive', BooleanModel, [true]);
  }

  get productId(): NumberModel {
    return this[_getPropertyModel]('productId', NumberModel, [true]);
  }

  get slogan(): StringModel {
    return this[_getPropertyModel]('slogan', StringModel, [true]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }

  get type(): StringModel {
    return this[_getPropertyModel]('type', StringModel, [true]);
  }
}
