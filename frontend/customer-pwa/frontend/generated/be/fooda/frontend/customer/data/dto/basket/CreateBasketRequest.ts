import CreateCustomerRequest from './CreateCustomerRequest';
import CreateProductRequest from './CreateProductRequest';
import CreateStoreRequest from './CreateStoreRequest';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.CreateBasketRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\CreateBasketRequest.java}
 */

export default interface CreateBasketRequest {
  customer?: CreateCustomerRequest;
  products?: Array<CreateProductRequest | undefined>;
  session?: string;
  store?: CreateStoreRequest;
}
