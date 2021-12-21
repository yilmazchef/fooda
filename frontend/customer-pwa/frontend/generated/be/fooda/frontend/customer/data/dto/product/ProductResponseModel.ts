// @ts-nocheck

import CategoryResponseModel from './CategoryResponseModel';
import IngredientResponseModel from './IngredientResponseModel';
import MediaResponseModel from './MediaResponseModel';
import PriceResponseModel from './PriceResponseModel';
import StoreResponseModel from './StoreResponseModel';
import TagResponseModel from './TagResponseModel';
import TaxResponseModel from './TaxResponseModel';
import TypeResponseModel from './TypeResponseModel';
import ProductResponse from './ProductResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.ProductResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\ProductResponse.java}
 */
export default class ProductResponseModel<T extends ProductResponse = ProductResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => ProductResponse;

  get categories(): ArrayModel<ModelType<CategoryResponseModel>, CategoryResponseModel> {
    return this[_getPropertyModel]('categories', ArrayModel, [true, CategoryResponseModel, [true]]);
  }

  get defaultImage(): MediaResponseModel {
    return this[_getPropertyModel]('defaultImage', MediaResponseModel, [true]);
  }

  get description(): StringModel {
    return this[_getPropertyModel]('description', StringModel, [true]);
  }

  get eTrackingId(): StringModel {
    return this[_getPropertyModel]('eTrackingId', StringModel, [true]);
  }

  get ingredients(): ArrayModel<ModelType<IngredientResponseModel>, IngredientResponseModel> {
    return this[_getPropertyModel]('ingredients', ArrayModel, [true, IngredientResponseModel, [true]]);
  }

  get isActive(): BooleanModel {
    return this[_getPropertyModel]('isActive', BooleanModel, [true]);
  }

  get isFeatured(): BooleanModel {
    return this[_getPropertyModel]('isFeatured', BooleanModel, [true]);
  }

  get limitPerOrder(): NumberModel {
    return this[_getPropertyModel]('limitPerOrder', NumberModel, [true]);
  }

  get prices(): ArrayModel<ModelType<PriceResponseModel>, PriceResponseModel> {
    return this[_getPropertyModel]('prices', ArrayModel, [true, PriceResponseModel, [true]]);
  }

  get productId(): NumberModel {
    return this[_getPropertyModel]('productId', NumberModel, [true]);
  }

  get store(): StoreResponseModel {
    return this[_getPropertyModel]('store', StoreResponseModel, [true]);
  }

  get tags(): ArrayModel<ModelType<TagResponseModel>, TagResponseModel> {
    return this[_getPropertyModel]('tags', ArrayModel, [true, TagResponseModel, [true]]);
  }

  get taxes(): ArrayModel<ModelType<TaxResponseModel>, TaxResponseModel> {
    return this[_getPropertyModel]('taxes', ArrayModel, [true, TaxResponseModel, [true]]);
  }

  get title(): StringModel {
    return this[_getPropertyModel]('title', StringModel, [true]);
  }

  get type(): TypeResponseModel {
    return this[_getPropertyModel]('type', TypeResponseModel, [true]);
  }
}
