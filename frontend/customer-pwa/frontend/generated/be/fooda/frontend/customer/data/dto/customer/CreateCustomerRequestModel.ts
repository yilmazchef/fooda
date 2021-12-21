// @ts-nocheck

import CreateCustomerRequest from './CreateCustomerRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.customer.CreateCustomerRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\customer\CreateCustomerRequest.java}
 */
export default class CreateCustomerRequestModel<T extends CreateCustomerRequest = CreateCustomerRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateCustomerRequest;

  get addressId(): NumberModel {
    return this[_getPropertyModel]('addressId', NumberModel, [true]);
  }

  get companyName(): StringModel {
    return this[_getPropertyModel]('companyName', StringModel, [true]);
  }

  get contactId(): NumberModel {
    return this[_getPropertyModel]('contactId', NumberModel, [true]);
  }

  get dateOfBirth(): StringModel {
    return this[_getPropertyModel]('dateOfBirth', StringModel, [true]);
  }

  get familyName(): StringModel {
    return this[_getPropertyModel]('familyName', StringModel, [true]);
  }

  get firstName(): StringModel {
    return this[_getPropertyModel]('firstName', StringModel, [true]);
  }

  get note(): StringModel {
    return this[_getPropertyModel]('note', StringModel, [true]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }

  get userId(): NumberModel {
    return this[_getPropertyModel]('userId', NumberModel, [true]);
  }
}
