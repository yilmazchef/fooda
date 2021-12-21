import DeliveryStatus from './DeliveryStatus';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.delivery.CreateDeliveryRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\delivery\CreateDeliveryRequest.java}
 */

export default interface CreateDeliveryRequest {
  courierId?: number;
  customerId?: number;
  deliveredAt?: string;
  note?: string;
  orderId?: number;
  requestedAt?: string;
  status?: DeliveryStatus;
  storeId?: number;
  trackingId?: string;
}
