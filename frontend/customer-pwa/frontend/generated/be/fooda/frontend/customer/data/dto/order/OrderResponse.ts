import CustomerResponse from './CustomerResponse';
import DeliveryResponse from './DeliveryResponse';
import OrderStatus from './OrderStatus';
import PaymentResponse from './PaymentResponse';
import ProductResponse from './ProductResponse';
import StoreResponse from './StoreResponse';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.order.OrderResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\order\OrderResponse.java}
 */

export default interface OrderResponse {
  createdAt?: string;
  customer?: CustomerResponse;
  deliveredAt?: string;
  delivery?: DeliveryResponse;
  deliveryTotal?: number;
  id?: number;
  isActive?: boolean;
  note?: string;
  paymentAt?: string;
  payments?: Array<PaymentResponse | undefined>;
  priceTotal?: number;
  products?: Array<ProductResponse | undefined>;
  productsTotal?: number;
  requiredAt?: string;
  status?: OrderStatus;
  store?: StoreResponse;
  taxTotal?: number;
  trackingId?: string;
  updatedAt?: string;
}
