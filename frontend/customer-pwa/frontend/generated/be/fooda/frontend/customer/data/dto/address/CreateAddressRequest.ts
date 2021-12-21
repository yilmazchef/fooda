import CreateCoordinateRequest from './CreateCoordinateRequest';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.address.CreateAddressRequest.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\address\CreateAddressRequest.java}
 */

export default interface CreateAddressRequest {
  city?: string;
  coordinate?: CreateCoordinateRequest;
  country?: string;
  countryCode?: string;
  door?: string;
  house?: string;
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
