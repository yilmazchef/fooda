/**
 * This module is generated from BasketClient.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\client\BasketClient.java}
 * @module BasketClient
 */

// @ts-ignore
import client from './connect-client.default';
import BasketResponse from './be/fooda/frontend/customer/data/dto/basket/BasketResponse';
import CreateBasketRequest from './be/fooda/frontend/customer/data/dto/basket/CreateBasketRequest';
import UpdateBasketRequest from './be/fooda/frontend/customer/data/dto/basket/UpdateBasketRequest';
import ResponseEntity from './org/springframework/http/ResponseEntity';

function _createFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('BasketClient', 'createFallBack');
}
export {_createFallBack as createFallBack};

function _create(
 product: CreateBasketRequest | undefined
): Promise<BasketResponse | undefined> {
 return client.call('BasketClient', 'create', {product});
}
export {_create as create};

function _deleteFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('BasketClient', 'deleteFallBack');
}
export {_deleteFallBack as deleteFallBack};

function _delete(
 basketId: string | undefined
): Promise<string | undefined> {
 return client.call('BasketClient', 'delete', {basketId});
}
export {_delete as delete};

function _deletePermanently(
 basketId: string | undefined
): Promise<string | undefined> {
 return client.call('BasketClient', 'deletePermanently', {basketId});
}
export {_deletePermanently as deletePermanently};

function _exists(
 session: string | undefined,
 storeId: number | undefined
): Promise<boolean | undefined> {
 return client.call('BasketClient', 'exists', {session, storeId});
}
export {_exists as exists};

function _findAll(
 pageNo: number,
 pageSize: number
): Promise<Array<BasketResponse | undefined> | undefined> {
 return client.call('BasketClient', 'findAll', {pageNo, pageSize});
}
export {_findAll as findAll};

function _findById(
 basketId: number | undefined
): Promise<BasketResponse | undefined> {
 return client.call('BasketClient', 'findById', {basketId});
}
export {_findById as findById};

function _findBySession(
 session: string | undefined
): Promise<Array<BasketResponse | undefined> | undefined> {
 return client.call('BasketClient', 'findBySession', {session});
}
export {_findBySession as findBySession};

function _findManyFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('BasketClient', 'findManyFallBack');
}
export {_findManyFallBack as findManyFallBack};

function _findSingleFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('BasketClient', 'findSingleFallBack');
}
export {_findSingleFallBack as findSingleFallBack};

function _updateById(
 basketId: string | undefined,
 request: UpdateBasketRequest | undefined
): Promise<BasketResponse | undefined> {
 return client.call('BasketClient', 'updateById', {basketId, request});
}
export {_updateById as updateById};

function _updateBySession(
 session: string | undefined,
 request: UpdateBasketRequest | undefined
): Promise<BasketResponse | undefined> {
 return client.call('BasketClient', 'updateBySession', {session, request});
}
export {_updateBySession as updateBySession};

function _updateFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('BasketClient', 'updateFallBack');
}
export {_updateFallBack as updateFallBack};

function _updateProductQuantity(
 basketId: number | undefined,
 productId: number | undefined,
 quantity: number | undefined
): Promise<BasketResponse | undefined> {
 return client.call('BasketClient', 'updateProductQuantity', {basketId, productId, quantity});
}
export {_updateProductQuantity as updateProductQuantity};

export const BasketClient = Object.freeze({
  createFallBack: _createFallBack,
  create: _create,
  deleteFallBack: _deleteFallBack,
  delete: _delete,
  deletePermanently: _deletePermanently,
  exists: _exists,
  findAll: _findAll,
  findById: _findById,
  findBySession: _findBySession,
  findManyFallBack: _findManyFallBack,
  findSingleFallBack: _findSingleFallBack,
  updateById: _updateById,
  updateBySession: _updateBySession,
  updateFallBack: _updateFallBack,
  updateProductQuantity: _updateProductQuantity,
});
