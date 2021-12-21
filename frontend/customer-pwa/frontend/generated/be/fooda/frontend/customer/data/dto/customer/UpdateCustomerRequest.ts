
/**
 * This module is generated from be.fooda.frontend.customer.data.dto.customer.UpdateCustomerRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\customer\UpdateCustomerRequest.java}
 */

export default interface UpdateCustomerRequest {
  addressId?: number;
  companyName?: string;
  contactId?: number;
  dateOfBirth?: string;
  familyName?: string;
  favoriteOrders?: Array<number | undefined>;
  favoriteProducts?: Array<number | undefined>;
  favoriteStores?: Array<number | undefined>;
  firstName?: string;
  id?: number;
  isActive?: boolean;
  note?: string;
  paymentOptions?: Array<number | undefined>;
  title?: string;
  userId?: number;
  validation?: string;
}
