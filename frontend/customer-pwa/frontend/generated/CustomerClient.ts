/**
 * This module is generated from CustomerClient.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\client\CustomerClient.java}
 * @module CustomerClient
 */

// @ts-ignore
import client from './connect-client.default';
import CreateCustomerRequest from './be/fooda/frontend/customer/data/dto/customer/CreateCustomerRequest';
import CustomerResponse from './be/fooda/frontend/customer/data/dto/customer/CustomerResponse';
import UpdateCustomerRequest from './be/fooda/frontend/customer/data/dto/customer/UpdateCustomerRequest';
import ResponseEntity from './org/springframework/http/ResponseEntity';

function _createFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('CustomerClient', 'createFallBack');
}
export {_createFallBack as createFallBack};

function _create(
 customer: CreateCustomerRequest | undefined
): Promise<CustomerResponse | undefined> {
 return client.call('CustomerClient', 'create', {customer});
}
export {_create as create};

function _deleteFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('CustomerClient', 'deleteFallBack');
}
export {_deleteFallBack as deleteFallBack};

function _findAllByUserId(
 userId: number | undefined
): Promise<Array<CustomerResponse | undefined> | undefined> {
 return client.call('CustomerClient', 'findAllByUserId', {userId});
}
export {_findAllByUserId as findAllByUserId};

function _findAll(
 pageNo: number,
 pageSize: number
): Promise<Array<CustomerResponse | undefined> | undefined> {
 return client.call('CustomerClient', 'findAll', {pageNo, pageSize});
}
export {_findAll as findAll};

function _findById(
 customerId: number | undefined
): Promise<CustomerResponse | undefined> {
 return client.call('CustomerClient', 'findById', {customerId});
}
export {_findById as findById};

function _findManyFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('CustomerClient', 'findManyFallBack');
}
export {_findManyFallBack as findManyFallBack};

function _findSingleFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('CustomerClient', 'findSingleFallBack');
}
export {_findSingleFallBack as findSingleFallBack};

function _search(
 keyword: string | undefined,
 pageNo: number,
 pageSize: number
): Promise<Array<CustomerResponse | undefined> | undefined> {
 return client.call('CustomerClient', 'search', {keyword, pageNo, pageSize});
}
export {_search as search};

function _updateFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('CustomerClient', 'updateFallBack');
}
export {_updateFallBack as updateFallBack};

function _update(
 customerId: number | undefined,
 customer: UpdateCustomerRequest | undefined
): Promise<CustomerResponse | undefined> {
 return client.call('CustomerClient', 'update', {customerId, customer});
}
export {_update as update};

export const CustomerClient = Object.freeze({
  createFallBack: _createFallBack,
  create: _create,
  deleteFallBack: _deleteFallBack,
  findAllByUserId: _findAllByUserId,
  findAll: _findAll,
  findById: _findById,
  findManyFallBack: _findManyFallBack,
  findSingleFallBack: _findSingleFallBack,
  search: _search,
  updateFallBack: _updateFallBack,
  update: _update,
});
