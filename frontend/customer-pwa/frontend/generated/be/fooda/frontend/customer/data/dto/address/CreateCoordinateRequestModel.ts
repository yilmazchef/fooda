// @ts-nocheck

import CreateCoordinateRequest from './CreateCoordinateRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.address.CreateCoordinateRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\address\CreateCoordinateRequest.java}
 */
export default class CreateCoordinateRequestModel<T extends CreateCoordinateRequest = CreateCoordinateRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateCoordinateRequest;

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
  }

  get latitude(): NumberModel {
    return this[_getPropertyModel]('latitude', NumberModel, [true]);
  }

  get longitude(): NumberModel {
    return this[_getPropertyModel]('longitude', NumberModel, [true]);
  }
}
