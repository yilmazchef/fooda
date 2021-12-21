// @ts-nocheck

import CreateTagRequest from './CreateTagRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.CreateTagRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\CreateTagRequest.java}
 */
export default class CreateTagRequestModel<T extends CreateTagRequest = CreateTagRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateTagRequest;

  get value(): StringModel {
    return this[_getPropertyModel]('value', StringModel, [true]);
  }
}