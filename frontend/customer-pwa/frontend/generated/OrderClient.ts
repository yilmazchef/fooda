/**
 * This module is generated from OrderClient.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\client\OrderClient.java}
 * @module OrderClient
 */

// @ts-ignore
import client from './connect-client.default';
import CreateOrderRequest from './be/fooda/frontend/customer/data/dto/order/CreateOrderRequest';
import OrderResponse from './be/fooda/frontend/customer/data/dto/order/OrderResponse';
import ResponseEntity from './org/springframework/http/ResponseEntity';

function _createFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('OrderClient', 'createFallBack');
}
export {_createFallBack as createFallBack};

function _create(
 order: CreateOrderRequest | undefined
): Promise<string | undefined> {
 return client.call('OrderClient', 'create', {order});
}
export {_create as create};

function _deleteFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('OrderClient', 'deleteFallBack');
}
export {_deleteFallBack as deleteFallBack};

function _findAll(
 pageNo: number,
 pageSize: number
): Promise<Array<OrderResponse | undefined> | undefined> {
 return client.call('OrderClient', 'findAll', {pageNo, pageSize});
}
export {_findAll as findAll};

function _findById(
 orderId: number | undefined
): Promise<OrderResponse | undefined> {
 return client.call('OrderClient', 'findById', {orderId});
}
export {_findById as findById};

function _findManyFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('OrderClient', 'findManyFallBack');
}
export {_findManyFallBack as findManyFallBack};

function _findSingleFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('OrderClient', 'findSingleFallBack');
}
export {_findSingleFallBack as findSingleFallBack};

function _search(
 keyword: string | undefined,
 pageNo: number,
 pageSize: number
): Promise<Array<OrderResponse | undefined> | undefined> {
 return client.call('OrderClient', 'search', {keyword, pageNo, pageSize});
}
export {_search as search};

function _updateFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('OrderClient', 'updateFallBack');
}
export {_updateFallBack as updateFallBack};

export const OrderClient = Object.freeze({
  createFallBack: _createFallBack,
  create: _create,
  deleteFallBack: _deleteFallBack,
  findAll: _findAll,
  findById: _findById,
  findManyFallBack: _findManyFallBack,
  findSingleFallBack: _findSingleFallBack,
  search: _search,
  updateFallBack: _updateFallBack,
});
