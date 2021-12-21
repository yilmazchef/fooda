// @ts-nocheck

import ContactResponse from './ContactResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.customer.ContactResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\customer\ContactResponse.java}
 */
export default class ContactResponseModel<T extends ContactResponse = ContactResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => ContactResponse;

  get canCall(): BooleanModel {
    return this[_getPropertyModel]('canCall', BooleanModel, [true]);
  }

  get contactId(): NumberModel {
    return this[_getPropertyModel]('contactId', NumberModel, [true]);
  }

  get email(): StringModel {
    return this[_getPropertyModel]('email', StringModel, [true]);
  }

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
  }

  get phone(): StringModel {
    return this[_getPropertyModel]('phone', StringModel, [true]);
  }
}
