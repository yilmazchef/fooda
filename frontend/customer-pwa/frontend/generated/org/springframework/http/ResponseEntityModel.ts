// @ts-nocheck

import HttpEntityModel from './HttpEntityModel';
import ResponseEntity from './ResponseEntity';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from org.springframework.http.ResponseEntity.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 */
export default class ResponseEntityModel<T extends ResponseEntity = ResponseEntity> extends HttpEntityModel<T> {
  static createEmptyValue: () => ResponseEntity;

  get status(): ObjectModel {
    return this[_getPropertyModel]('status', ObjectModel, [true]);
  }
}
