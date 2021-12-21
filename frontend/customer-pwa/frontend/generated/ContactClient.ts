/**
 * This module is generated from ContactClient.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\client\ContactClient.java}
 * @module ContactClient
 */

// @ts-ignore
import client from './connect-client.default';
import CreateContactRequest from './be/fooda/frontend/customer/data/dto/contact/CreateContactRequest';
import ContactResponse from './be/fooda/frontend/customer/data/dto/customer/ContactResponse';
import ResponseEntity from './org/springframework/http/ResponseEntity';

function _createFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ContactClient', 'createFallBack');
}
export {_createFallBack as createFallBack};

function _create(
 contact: CreateContactRequest | undefined
): Promise<string | undefined> {
 return client.call('ContactClient', 'create', {contact});
}
export {_create as create};

function _deleteFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ContactClient', 'deleteFallBack');
}
export {_deleteFallBack as deleteFallBack};

function _findAll(
 pageNo: number,
 pageSize: number
): Promise<Array<ContactResponse | undefined> | undefined> {
 return client.call('ContactClient', 'findAll', {pageNo, pageSize});
}
export {_findAll as findAll};

function _findById(
 contactId: number | undefined
): Promise<ContactResponse | undefined> {
 return client.call('ContactClient', 'findById', {contactId});
}
export {_findById as findById};

function _findManyFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ContactClient', 'findManyFallBack');
}
export {_findManyFallBack as findManyFallBack};

function _findSingleFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ContactClient', 'findSingleFallBack');
}
export {_findSingleFallBack as findSingleFallBack};

function _search(
 keyword: string | undefined,
 pageNo: number,
 pageSize: number
): Promise<Array<ContactResponse | undefined> | undefined> {
 return client.call('ContactClient', 'search', {keyword, pageNo, pageSize});
}
export {_search as search};

function _updateFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('ContactClient', 'updateFallBack');
}
export {_updateFallBack as updateFallBack};

export const ContactClient = Object.freeze({
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
