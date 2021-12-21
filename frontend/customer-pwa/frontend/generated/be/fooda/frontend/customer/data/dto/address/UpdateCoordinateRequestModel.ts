// @ts-nocheck

import UpdateCoordinateRequest from './UpdateCoordinateRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.address.UpdateCoordinateRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\address\UpdateCoordinateRequest.java}
 */
export default class UpdateCoordinateRequestModel<T extends UpdateCoordinateRequest = UpdateCoordinateRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => UpdateCoordinateRequest;

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
