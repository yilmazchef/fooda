import CreateCategoryRequest from './CreateCategoryRequest';
import CreateIngredientRequest from './CreateIngredientRequest';
import CreatePriceRequest from './CreatePriceRequest';
import CreateTagRequest from './CreateTagRequest';
import CreateTaxRequest from './CreateTaxRequest';
import CreateTypeRequest from './CreateTypeRequest';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.CreateProductRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\CreateProductRequest.java}
 */

export default interface CreateProductRequest {
  categories?: Array<CreateCategoryRequest | undefined>;
  defaultImageId?: number;
  description?: string;
  eTrackingId?: string;
  ingredients?: Array<CreateIngredientRequest | undefined>;
  isFeatured?: boolean;
  limitPerOrder?: number;
  prices?: Array<CreatePriceRequest | undefined>;
  storeId?: number;
  tags?: Array<CreateTagRequest | undefined>;
  taxes?: Array<CreateTaxRequest | undefined>;
  title?: string;
  type?: CreateTypeRequest;
}
