import UpdateCategoryRequest from './UpdateCategoryRequest';
import UpdateIngredientRequest from './UpdateIngredientRequest';
import UpdatePriceRequest from './UpdatePriceRequest';
import UpdateTagRequest from './UpdateTagRequest';
import UpdateTaxRequest from './UpdateTaxRequest';
import UpdateTypeRequest from './UpdateTypeRequest';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.UpdateProductRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\UpdateProductRequest.java}
 */

export default interface UpdateProductRequest {
  categories?: Array<UpdateCategoryRequest | undefined>;
  defaultImageId?: number;
  description?: string;
  eTrackingId?: string;
  ingredients?: Array<UpdateIngredientRequest | undefined>;
  isFeatured?: boolean;
  limitPerOrder?: number;
  prices?: Array<UpdatePriceRequest | undefined>;
  storeId?: number;
  tags?: Array<UpdateTagRequest | undefined>;
  taxes?: Array<UpdateTaxRequest | undefined>;
  title?: string;
  type?: UpdateTypeRequest;
}
