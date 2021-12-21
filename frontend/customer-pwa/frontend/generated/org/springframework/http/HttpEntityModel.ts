// @ts-nocheck

import HttpEntity from './HttpEntity';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from org.springframework.http.HttpEntity.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 */
export default class HttpEntityModel<T extends HttpEntity = HttpEntity> extends ObjectModel<T> { 
  static createEmptyValue: () => HttpEntity;

  get body(): ObjectModel {
    return this[_getPropertyModel]('body', ObjectModel, [true]);
  }

  get headers(): ObjectModel {
    return this[_getPropertyModel]('headers', ObjectModel, [true]);
  }
}
