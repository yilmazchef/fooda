// @ts-nocheck

import AddressResponseModel from './AddressResponseModel';
import ContactResponseModel from './ContactResponseModel';
import OrderResponseModel from './OrderResponseModel';
import PaymentResponseModel from './PaymentResponseModel';
import ProductResponseModel from './ProductResponseModel';
import StoreResponseModel from './StoreResponseModel';
import UserResponseModel from './UserResponseModel';
import CustomerResponse from './CustomerResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.customer.CustomerResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\customer\CustomerResponse.java}
 */
export default class CustomerResponseModel<T extends CustomerResponse = CustomerResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => CustomerResponse;

  get companyName(): StringModel {
    return this[_getPropertyModel]('companyName', StringModel, [true]);
  }

  get createdAt(): StringModel {
    return this[_getPropertyModel]('createdAt', StringModel, [true]);
  }

  get currentAddress(): AddressResponseModel {
    return this[_getPropertyModel]('currentAddress', AddressResponseModel, [true]);
  }

  get currentContact(): ContactResponseModel {
    return this[_getPropertyModel]('currentContact', ContactResponseModel, [true]);
  }

  get dateOfBirth(): StringModel {
    return this[_getPropertyModel]('dateOfBirth', StringModel, [true]);
  }

  get familyName(): StringModel {
    return this[_getPropertyModel]('familyName', StringModel, [true]);
  }

  get favoriteOrders(): ArrayModel<ModelType<OrderResponseModel>, OrderResponseModel> {
    return this[_getPropertyModel]('favoriteOrders', ArrayModel, [true, OrderResponseModel, [true]]);
  }

  get favoriteProducts(): ArrayModel<ModelType<ProductResponseModel>, ProductResponseModel> {
    return this[_getPropertyModel]('favoriteProducts', ArrayModel, [true, ProductResponseModel, [true]]);
  }

  get favoriteStores(): ArrayModel<ModelType<StoreResponseModel>, StoreResponseModel> {
    return this[_getPropertyModel]('favoriteStores', ArrayModel, [true, StoreResponseModel, [true]]);
  }

  get firstName(): StringModel {
    return this[_getPropertyModel]('firstName', StringModel, [true]);
  }

  get id(): NumberModel {
    return this[_getPropertyModel]('id', NumberModel, [true]);
  }

  get isActive(): BooleanModel {
    return this[_getPropertyModel]('isActive', BooleanModel, [true]);
  }

  get note(): StringModel {
    return this[_getPropertyModel]('note', StringModel, [true]);
  }

  get paymentOptions(): ArrayModel<ModelType<PaymentResponseModel>, PaymentResponseModel> {
    return this[_getPropertyModel]('paymentOptions', ArrayModel, [true, PaymentResponseModel, [true]]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }

  get updatedAt(): StringModel {
    return this[_getPropertyModel]('updatedAt', StringModel, [true]);
  }

  get user(): UserResponseModel {
    return this[_getPropertyModel]('user', UserResponseModel, [true]);
  }

  get userId(): NumberModel {
    return this[_getPropertyModel]('userId', NumberModel, [true]);
  }

  get validation(): StringModel {
    return this[_getPropertyModel]('validation', StringModel, [true]);
  }
}
