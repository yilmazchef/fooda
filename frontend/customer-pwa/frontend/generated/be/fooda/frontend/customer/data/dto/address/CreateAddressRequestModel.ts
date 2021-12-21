// @ts-nocheck

import CreateCoordinateRequestModel from './CreateCoordinateRequestModel';
import CreateAddressRequest from './CreateAddressRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.address.CreateAddressRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\address\CreateAddressRequest.java}
 */
export default class CreateAddressRequestModel<T extends CreateAddressRequest = CreateAddressRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateAddressRequest;

  get city(): StringModel {
    return this[_getPropertyModel]('city', StringModel, [true]);
  }

  get coordinate(): CreateCoordinateRequestModel {
    return this[_getPropertyModel]('coordinate', CreateCoordinateRequestModel, [true]);
  }

  get country(): StringModel {
    return this[_getPropertyModel]('country', StringModel, [true]);
  }

  get countryCode(): StringModel {
    return this[_getPropertyModel]('countryCode', StringModel, [true]);
  }

  get door(): StringModel {
    return this[_getPropertyModel]('door', StringModel, [true]);
  }

  get house(): StringModel {
    return this[_getPropertyModel]('house', StringModel, [true]);
  }

  get isActive(): BooleanModel {
    return this[_getPropertyModel]('isActive', BooleanModel, [true]);
  }

  get isCurrent(): BooleanModel {
    return this[_getPropertyModel]('isCurrent', BooleanModel, [true]);
  }

  get municipality(): StringModel {
    return this[_getPropertyModel]('municipality', StringModel, [true]);
  }

  get postcode(): StringModel {
    return this[_getPropertyModel]('postcode', StringModel, [true]);
  }

  get region(): StringModel {
    return this[_getPropertyModel]('region', StringModel, [true]);
  }

  get registeredAt(): StringModel {
    return this[_getPropertyModel]('registeredAt', StringModel, [true]);
  }

  get street(): StringModel {
    return this[_getPropertyModel]('street', StringModel, [true]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }

  get updatedAt(): StringModel {
    return this[_getPropertyModel]('updatedAt', StringModel, [true]);
  }

  get userId(): NumberModel {
    return this[_getPropertyModel]('userId', NumberModel, [true]);
  }
}
