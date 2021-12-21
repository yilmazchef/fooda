import OrderStatus from './OrderStatus';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.order.CreateOrderRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\order\CreateOrderRequest.java}
 */

export default interface CreateOrderRequest {
  createdAt?: string;
  customerId?: number;
  deliveredAt?: string;
  deliveryId?: number;
  deliveryTotal?: number;
  isActive?: boolean;
  note?: string;
  paymentAt?: string;
  payments?: Array<number | undefined>;
  priceTotal?: number;
  products?: Array<number | undefined>;
  productsTotal?: number;
  requiredAt?: string;
  status?: OrderStatus;
  storeId?: number;
  taxTotal?: number;
  trackingId?: string;
  updatedAt?: string;
}
