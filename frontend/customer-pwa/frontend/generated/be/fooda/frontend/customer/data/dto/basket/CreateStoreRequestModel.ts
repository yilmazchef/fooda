// @ts-nocheck

import CreateStoreRequest from './CreateStoreRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.CreateStoreRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\CreateStoreRequest.java}
 */
export default class CreateStoreRequestModel<T extends CreateStoreRequest = CreateStoreRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateStoreRequest;

  get addressId(): NumberModel {
    return this[_getPropertyModel]('addressId', NumberModel, [true]);
  }

  get contactId(): NumberModel {
    return this[_getPropertyModel]('contactId', NumberModel, [true]);
  }

  get storeId(): NumberModel {
    return this[_getPropertyModel]('storeId', NumberModel, [true]);
  }
}
