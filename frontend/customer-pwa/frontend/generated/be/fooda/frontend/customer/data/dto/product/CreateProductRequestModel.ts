// @ts-nocheck

import CreateCategoryRequestModel from './CreateCategoryRequestModel';
import CreateIngredientRequestModel from './CreateIngredientRequestModel';
import CreatePriceRequestModel from './CreatePriceRequestModel';
import CreateTagRequestModel from './CreateTagRequestModel';
import CreateTaxRequestModel from './CreateTaxRequestModel';
import CreateTypeRequestModel from './CreateTypeRequestModel';
import CreateProductRequest from './CreateProductRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.CreateProductRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\CreateProductRequest.java}
 */
export default class CreateProductRequestModel<T extends CreateProductRequest = CreateProductRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => CreateProductRequest;

  get categories(): ArrayModel<ModelType<CreateCategoryRequestModel>, CreateCategoryRequestModel> {
    return this[_getPropertyModel]('categories', ArrayModel, [true, CreateCategoryRequestModel, [true]]);
  }

  get defaultImageId(): NumberModel {
    return this[_getPropertyModel]('defaultImageId', NumberModel, [true]);
  }

  get description(): StringModel {
    return this[_getPropertyModel]('description', StringModel, [true]);
  }

  get eTrackingId(): StringModel {
    return this[_getPropertyModel]('eTrackingId', StringModel, [true]);
  }

  get ingredients(): ArrayModel<ModelType<CreateIngredientRequestModel>, CreateIngredientRequestModel> {
    return this[_getPropertyModel]('ingredients', ArrayModel, [true, CreateIngredientRequestModel, [true]]);
  }

  get isFeatured(): BooleanModel {
    return this[_getPropertyModel]('isFeatured', BooleanModel, [true]);
  }

  get limitPerOrder(): NumberModel {
    return this[_getPropertyModel]('limitPerOrder', NumberModel, [true]);
  }

  get prices(): ArrayModel<ModelType<CreatePriceRequestModel>, CreatePriceRequestModel> {
    return this[_getPropertyModel]('prices', ArrayModel, [true, CreatePriceRequestModel, [true]]);
  }

  get storeId(): NumberModel {
    return this[_getPropertyModel]('storeId', NumberModel, [true]);
  }

  get tags(): ArrayModel<ModelType<CreateTagRequestModel>, CreateTagRequestModel> {
    return this[_getPropertyModel]('tags', ArrayModel, [true, CreateTagRequestModel, [true]]);
  }

  get taxes(): ArrayModel<ModelType<CreateTaxRequestModel>, CreateTaxRequestModel> {
    return this[_getPropertyModel]('taxes', ArrayModel, [true, CreateTaxRequestModel, [true]]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }

  get type(): CreateTypeRequestModel {
    return this[_getPropertyModel]('type', CreateTypeRequestModel, [true]);
  }
}
