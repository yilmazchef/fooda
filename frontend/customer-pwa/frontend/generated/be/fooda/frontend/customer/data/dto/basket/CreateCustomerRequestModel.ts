// @ts-nocheck

import CreateCustomerRequest from './CreateCustomerRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.CreateCustomerRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\CreateCustomerRequest.java}
 */
export default class CreateCustomerRequestModel<T extends CreateCustomerRequest = CreateCustomerRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateCustomerRequest;

  get billingAddressId(): NumberModel {
    return this[_getPropertyModel]('billingAddressId', NumberModel, [true]);
  }

  get billingContactId(): NumberModel {
    return this[_getPropertyModel]('billingContactId', NumberModel, [true]);
  }

  get customerId(): NumberModel {
    return this[_getPropertyModel]('customerId', NumberModel, [true]);
  }

  get deliveryAddressId(): NumberModel {
    return this[_getPropertyModel]('deliveryAddressId', NumberModel, [true]);
  }

  get deliveryContactId(): NumberModel {
    return this[_getPropertyModel]('deliveryContactId', NumberModel, [true]);
  }
}
