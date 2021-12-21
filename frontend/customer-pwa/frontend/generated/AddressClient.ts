/**
 * This module is generated from AddressClient.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\client\AddressClient.java}
 * @module AddressClient
 */

// @ts-ignore
import client from './connect-client.default';
import CreateAddressRequest from './be/fooda/frontend/customer/data/dto/address/CreateAddressRequest';
import UpdateAddressRequest from './be/fooda/frontend/customer/data/dto/address/UpdateAddressRequest';
import ResponseEntity from './org/springframework/http/ResponseEntity';

function _createFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'createFallBack');
}
export {_createFallBack as createFallBack};

function _create(
 address: CreateAddressRequest | undefined
): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'create', {address});
}
export {_create as create};

function _deleteFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'deleteFallBack');
}
export {_deleteFallBack as deleteFallBack};

function _findById(
 addressId: number | undefined
): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'findById', {addressId});
}
export {_findById as findById};

function _findByUserId(
 userId: number | undefined,
 pageNo: number | undefined,
 pageSize: number | undefined
): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'findByUserId', {userId, pageNo, pageSize});
}
export {_findByUserId as findByUserId};

function _findManyFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'findManyFallBack');
}
export {_findManyFallBack as findManyFallBack};

function _findSingleFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'findSingleFallBack');
}
export {_findSingleFallBack as findSingleFallBack};

function _search(
 keyword: string | undefined,
 pageNo: number,
 pageSize: number
): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'search', {keyword, pageNo, pageSize});
}
export {_search as search};

function _updateFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'updateFallBack');
}
export {_updateFallBack as updateFallBack};

function _update(
 addressId: number | undefined,
 address: UpdateAddressRequest | undefined
): Promise<ResponseEntity | undefined> {
 return client.call('AddressClient', 'update', {addressId, address});
}
export {_update as update};

export const AddressClient = Object.freeze({
  createFallBack: _createFallBack,
  create: _create,
  deleteFallBack: _deleteFallBack,
  findById: _findById,
  findByUserId: _findByUserId,
  findManyFallBack: _findManyFallBack,
  findSingleFallBack: _findSingleFallBack,
  search: _search,
  updateFallBack: _updateFallBack,
  update: _update,
});
