import DeliveryStatus from './DeliveryStatus';
import CourierClientResponse from './remote/CourierClientResponse';
import CustomerClientResponse from './remote/CustomerClientResponse';
import OrderClientResponse from './remote/OrderClientResponse';
import StoreClientResponse from './remote/StoreClientResponse';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.delivery.DeliveryResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\delivery\DeliveryResponse.java}
 */

export default interface DeliveryResponse {
  courier?: CourierClientResponse;
  customer?: CustomerClientResponse;
  id?: number;
  note?: string;
  order?: OrderClientResponse;
  status?: DeliveryStatus;
  store?: StoreClientResponse;
  trackingId?: string;
}
