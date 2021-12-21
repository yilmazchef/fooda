// @ts-nocheck

import CreateContactRequest from './CreateContactRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.contact.CreateContactRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\contact\CreateContactRequest.java}
 */
export default class CreateContactRequestModel<T extends CreateContactRequest = CreateContactRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateContactRequest;

  get canCall(): BooleanModel {
    return this[_getPropertyModel]('canCall', BooleanModel, [true]);
  }

  get companyName(): StringModel {
    return this[_getPropertyModel]('companyName', StringModel, [true]);
  }

  get email(): StringModel {
    return this[_getPropertyModel]('email', StringModel, [true]);
  }

  get externalUserId(): ObjectModel {
    return this[_getPropertyModel]('externalUserId', ObjectModel, [true]);
  }

  get familyName(): StringModel {
    return this[_getPropertyModel]('familyName', StringModel, [true]);
  }

  get firstName(): StringModel {
    return this[_getPropertyModel]('firstName', StringModel, [true]);
  }

  get linePhoneNumber(): StringModel {
    return this[_getPropertyModel]('linePhoneNumber', StringModel, [true]);
  }

  get mobilePhoneNumber(): StringModel {
    return this[_getPropertyModel]('mobilePhoneNumber', StringModel, [true]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }
}
