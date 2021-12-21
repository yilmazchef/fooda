import UpdatePaymentRequest from './UpdatePaymentRequest';
import UpdateProductRequest from './UpdateProductRequest';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.basket.UpdateBasketRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\basket\UpdateBasketRequest.java}
 */

export default interface UpdateBasketRequest {
  payments?: Array<UpdatePaymentRequest | undefined>;
  products?: Array<UpdateProductRequest | undefined>;
}
