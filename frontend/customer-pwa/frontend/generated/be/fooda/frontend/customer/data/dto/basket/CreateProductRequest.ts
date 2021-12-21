import CreateMediaRequest from './CreateMediaRequest';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.CreateProductRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\CreateProductRequest.java}
 */

export default interface CreateProductRequest {
  discount?: number;
  media?: CreateMediaRequest;
  price?: number;
  productId?: number;
  quantity?: number;
  title?: string;
}
