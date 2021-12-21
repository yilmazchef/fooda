import UpdateCoordinateRequest from './UpdateCoordinateRequest';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.address.UpdateAddressRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\address\UpdateAddressRequest.java}
 */

export default interface UpdateAddressRequest {
  city?: string;
  coordinate?: UpdateCoordinateRequest;
  country?: string;
  countryCode?: string;
  door?: string;
  house?: string;
  id?: number;
  isActive?: boolean;
  isCurrent?: boolean;
  municipality?: string;
  postcode?: string;
  region?: string;
  registeredAt?: string;
  street?: string;
  title?: string;
  updatedAt?: string;
  userId?: number;
}
