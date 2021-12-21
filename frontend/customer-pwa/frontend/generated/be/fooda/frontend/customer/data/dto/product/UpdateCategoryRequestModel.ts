// @ts-nocheck

import UpdateCategoryRequest from './UpdateCategoryRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.UpdateCategoryRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\UpdateCategoryRequest.java}
 */
export default class UpdateCategoryRequestModel<T extends UpdateCategoryRequest = UpdateCategoryRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => UpdateCategoryRequest;

  get icon(): ArrayModel<number, NumberModel> {
    return this[_getPropertyModel]('icon', ArrayModel, [true, NumberModel, [true]]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }
}
