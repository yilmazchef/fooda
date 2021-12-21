import CategoryResponse from './CategoryResponse';
import IngredientResponse from './IngredientResponse';
import MediaResponse from './MediaResponse';
import PriceResponse from './PriceResponse';
import StoreResponse from './StoreResponse';
import TagResponse from './TagResponse';
import TaxResponse from './TaxResponse';
import TypeResponse from './TypeResponse';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.product.ProductResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\product\ProductResponse.java}
 */

export default interface ProductResponse {
  categories?: Array<CategoryResponse | undefined>;
  defaultImage?: MediaResponse;
  description?: string;
  eTrackingId?: string;
  ingredients?: Array<IngredientResponse | undefined>;
  isActive?: boolean;
  isFeatured?: boolean;
  limitPerOrder?: number;
  prices?: Array<PriceResponse | undefined>;
  productId?: number;
  store?: StoreResponse;
  tags?: Array<TagResponse | undefined>;
  taxes?: Array<TaxResponse | undefined>;
  title?: string;
  type?: TypeResponse;
}
