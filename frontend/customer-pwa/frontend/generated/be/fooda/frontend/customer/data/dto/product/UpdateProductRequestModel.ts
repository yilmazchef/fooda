// @ts-nocheck

import UpdateCategoryRequestModel from './UpdateCategoryRequestModel';
import UpdateIngredientRequestModel from './UpdateIngredientRequestModel';
import UpdatePriceRequestModel from './UpdatePriceRequestModel';
import UpdateTagRequestModel from './UpdateTagRequestModel';
import UpdateTaxRequestModel from './UpdateTaxRequestModel';
import UpdateTypeRequestModel from './UpdateTypeRequestModel';
import UpdateProductRequest from './UpdateProductRequest';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.UpdateProductRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\UpdateProductRequest.java}
 */
export default class UpdateProductRequestModel<T extends UpdateProductRequest = UpdateProductRequest> extends ObjectModel<T> { 
  static createEmptyValue: () => UpdateProductRequest;

  get categories(): ArrayModel<ModelType<UpdateCategoryRequestModel>, UpdateCategoryRequestModel> {
    return this[_getPropertyModel]('categories', ArrayModel, [true, UpdateCategoryRequestModel, [true]]);
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

  get ingredients(): ArrayModel<ModelType<UpdateIngredientRequestModel>, UpdateIngredientRequestModel> {
    return this[_getPropertyModel]('ingredients', ArrayModel, [true, UpdateIngredientRequestModel, [true]]);
  }

  get isFeatured(): BooleanModel {
    return this[_getPropertyModel]('isFeatured', BooleanModel, [true]);
  }

  get limitPerOrder(): NumberModel {
    return this[_getPropertyModel]('limitPerOrder', NumberModel, [true]);
  }

  get prices(): ArrayModel<ModelType<UpdatePriceRequestModel>, UpdatePriceRequestModel> {
    return this[_getPropertyModel]('prices', ArrayModel, [true, UpdatePriceRequestModel, [true]]);
  }

  get storeId(): NumberModel {
    return this[_getPropertyModel]('storeId', NumberModel, [true]);
  }

  get tags(): ArrayModel<ModelType<UpdateTagRequestModel>, UpdateTagRequestModel> {
    return this[_getPropertyModel]('tags', ArrayModel, [true, UpdateTagRequestModel, [true]]);
  }

  get taxes(): ArrayModel<ModelType<UpdateTaxRequestModel>, UpdateTaxRequestModel> {
    return this[_getPropertyModel]('taxes', ArrayModel, [true, UpdateTaxRequestModel, [true]]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }

  get type(): UpdateTypeRequestModel {
    return this[_getPropertyModel]('type', UpdateTypeRequestModel, [true]);
  }
}
