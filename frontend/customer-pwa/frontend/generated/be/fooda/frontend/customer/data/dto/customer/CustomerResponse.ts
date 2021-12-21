import AddressResponse from './AddressResponse';
import ContactResponse from './ContactResponse';
import OrderResponse from './OrderResponse';
import PaymentResponse from './PaymentResponse';
import ProductResponse from './ProductResponse';
import StoreResponse from './StoreResponse';
import UserResponse from './UserResponse';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.customer.CustomerResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\customer\CustomerResponse.java}
 */

export default interface CustomerResponse {
  companyName?: string;
  createdAt?: string;
  currentAddress?: AddressResponse;
  currentContact?: ContactResponse;
  dateOfBirth?: string;
  familyName?: string;
  favoriteOrders?: Array<OrderResponse | undefined>;
  favoriteProducts?: Array<ProductResponse | undefined>;
  favoriteStores?: Array<StoreResponse | undefined>;
  firstName?: string;
  id?: number;
  isActive?: boolean;
  note?: string;
  paymentOptions?: Array<PaymentResponse | undefined>;
  title?: string;
  updatedAt?: string;
  user?: UserResponse;
  userId?: number;
  validation?: string;
}
