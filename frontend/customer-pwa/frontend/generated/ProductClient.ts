/**
 * This module is generated from ProductClient.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\client\ProductClient.java}
 * @module ProductClient
 */

// @ts-ignore
import client from './connect-client.default';
import CreateProductRequest from './be/fooda/frontend/customer/data/dto/product/CreateProductRequest';
import ProductResponse from './be/fooda/frontend/customer/data/dto/product/ProductResponse';
import UpdateProductRequest from './be/fooda/frontend/customer/data/dto/product/UpdateProductRequest';
import ResponseEntity from './org/springframework/http/ResponseEntity';

function _createFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ProductClient', 'createFallBack');
}
export {_createFallBack as createFallBack};

function _create(
 product: CreateProductRequest | undefined
): Promise<ProductResponse | undefined> {
 return client.call('ProductClient', 'create', {product});
}
export {_create as create};

function _deleteFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ProductClient', 'deleteFallBack');
}
export {_deleteFallBack as deleteFallBack};

function _findAll(
 pageNo: number,
 pageSize: number
): Promise<Array<ProductResponse | undefined> | undefined> {
 return client.call('ProductClient', 'findAll', {pageNo, pageSize});
}
export {_findAll as findAll};

function _findById(
 productId: number | undefined
): Promise<ProductResponse | undefined> {
 return client.call('ProductClient', 'findById', {productId});
}
export {_findById as findById};

function _findManyFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ProductClient', 'findManyFallBack');
}
export {_findManyFallBack as findManyFallBack};

function _findSingleFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ProductClient', 'findSingleFallBack');
}
export {_findSingleFallBack as findSingleFallBack};

function _search(
 keyword: string | undefined,
 pageNo: number,
 pageSize: number
): Promise<Array<ProductResponse | undefined> | undefined> {
 return client.call('ProductClient', 'search', {keyword, pageNo, pageSize});
}
export {_search as search};

function _updateFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ProductClient', 'updateFallBack');
}
export {_updateFallBack as updateFallBack};

function _update(
 productId: number | undefined,
 product: UpdateProductRequest | undefined
): Promise<ProductResponse | undefined> {
 return client.call('ProductClient', 'update', {productId, product});
}
export {_update as update};

export const ProductClient = Object.freeze({
  createFallBack: _createFallBack,
  create: _create,
  deleteFallBack: _deleteFallBack,
  findAll: _findAll,
  findById: _findById,
  findManyFallBack: _findManyFallBack,
  findSingleFallBack: _findSingleFallBack,
  search: _search,
  updateFallBack: _updateFallBack,
  update: _update,
});
