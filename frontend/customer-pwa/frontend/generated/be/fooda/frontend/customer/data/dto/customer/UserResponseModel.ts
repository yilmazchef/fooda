// @ts-nocheck

import UserResponse from './UserResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.customer.UserResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\customer\UserResponse.java}
 */
export default class UserResponseModel<T extends UserResponse = UserResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => UserResponse;

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
  }

  get userId(): NumberModel {
    return this[_getPropertyModel]('userId', NumberModel, [true]);
  }

  get username(): StringModel {
    return this[_getPropertyModel]('username', StringModel, [true]);
  }
}
