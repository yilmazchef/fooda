// @ts-nocheck

import MediaResponse from './MediaResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.MediaResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\MediaResponse.java}
 */
export default class MediaResponseModel<T extends MediaResponse = MediaResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => MediaResponse;

  get mediaId(): NumberModel {
    return this[_getPropertyModel]('mediaId', NumberModel, [true]);
  }

  get url(): StringModel {
    return this[_getPropertyModel]('url', StringModel, [true]);
  }
}
