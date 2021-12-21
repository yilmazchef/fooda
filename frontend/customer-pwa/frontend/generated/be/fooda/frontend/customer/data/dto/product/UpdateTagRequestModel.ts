// @ts-nocheck

import UpdateTagRequest from './UpdateTagRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.UpdateTagRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\UpdateTagRequest.java}
 */
export default class UpdateTagRequestModel<T extends UpdateTagRequest = UpdateTagRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => UpdateTagRequest;

  get value(): StringModel {
    return this[_getPropertyModel]('value', StringModel, [true]);
  }
}
