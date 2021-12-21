/**
 * This module is generated from DeliveryClient.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\client\DeliveryClient.java}
 * @module DeliveryClient
 */

// @ts-ignore
import client from './connect-client.default';
import CreateDeliveryRequest from './be/fooda/frontend/customer/data/dto/delivery/CreateDeliveryRequest';
import DeliveryResponse from './be/fooda/frontend/customer/data/dto/delivery/DeliveryResponse';
import UpdateDeliveryRequest from './be/fooda/frontend/customer/data/dto/delivery/UpdateDeliveryRequest';
import ResponseEntity from './org/springframework/http/ResponseEntity';

function _createFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('DeliveryClient', 'createFallBack');
}
export {_createFallBack as createFallBack};

function _create(
 delivery: CreateDeliveryRequest | undefined
): Promise<DeliveryResponse | undefined> {
 return client.call('DeliveryClient', 'create', {delivery});
}
export {_create as create};

function _deleteFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('DeliveryClient', 'deleteFallBack');
}
export {_deleteFallBack as deleteFallBack};

function _delete(
 deliveryId: number | undefined
): Promise<string | undefined> {
 return client.call('DeliveryClient', 'delete', {deliveryId});
}
export {_delete as delete};

function _deletePermanently(
 deliveryId: number | undefined
): Promise<string | undefined> {
 return client.call('DeliveryClient', 'deletePermanently', {deliveryId});
}
export {_deletePermanently as deletePermanently};

function _existById(
 deliveryId: number | undefined
): Promise<boolean | undefined> {
 return client.call('DeliveryClient', 'existById', {deliveryId});
}
export {_existById as existById};

function _findAll(
 pageNo: number,
 pageSize: number
): Promise<Array<DeliveryResponse | undefined> | undefined> {
 return client.call('DeliveryClient', 'findAll', {pageNo, pageSize});
}
export {_findAll as findAll};

function _findById(
 deliveryId: number | undefined
): Promise<DeliveryResponse | undefined> {
 return client.call('DeliveryClient', 'findById', {deliveryId});
}
export {_findById as findById};

function _findManyFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('DeliveryClient', 'findManyFallBack');
}
export {_findManyFallBack as findManyFallBack};

function _findSingleFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('DeliveryClient', 'findSingleFallBack');
}
export {_findSingleFallBack as findSingleFallBack};

function _getByOrderAndStore(
 orderId: number | undefined,
 storeId: number | undefined
): Promise<boolean | undefined> {
 return client.call('DeliveryClient', 'getByOrderAndStore', {orderId, storeId});
}
export {_getByOrderAndStore as getByOrderAndStore};

function _search(
 keyword: string | undefined
): Promise<Array<DeliveryResponse | undefined> | undefined> {
 return client.call('DeliveryClient', 'search', {keyword});
}
export {_search as search};

function _updateFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('DeliveryClient', 'updateFallBack');
}
export {_updateFallBack as updateFallBack};

function _update(
 deliveryId: number | undefined,
 delivery: UpdateDeliveryRequest | undefined
): Promise<DeliveryResponse | undefined> {
 return client.call('DeliveryClient', 'update', {deliveryId, delivery});
}
export {_update as update};

export const DeliveryClient = Object.freeze({
  createFallBack: _createFallBack,
  create: _create,
  deleteFallBack: _deleteFallBack,
  delete: _delete,
  deletePermanently: _deletePermanently,
  existById: _existById,
  findAll: _findAll,
  findById: _findById,
  findManyFallBack: _findManyFallBack,
  findSingleFallBack: _findSingleFallBack,
  getByOrderAndStore: _getByOrderAndStore,
  search: _search,
  updateFallBack: _updateFallBack,
  update: _update,
});
