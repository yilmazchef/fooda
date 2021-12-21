// @ts-nocheck

import TagResponse from './TagResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.TagResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\TagResponse.java}
 */
export default class TagResponseModel<T extends TagResponse = TagResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => TagResponse;

  get tagId(): NumberModel {
    return this[_getPropertyModel]('tagId', NumberModel, [true]);
  }

  get value(): StringModel {
    return this[_getPropertyModel]('value', StringModel, [true]);
  }
}
