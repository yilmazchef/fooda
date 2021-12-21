/**
 * This module is generated from MediaClient.java
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\client\MediaClient.java}
 * @module MediaClient
 */

// @ts-ignore
import client from './connect-client.default';
import CreateImageRequest from './be/fooda/frontend/customer/data/dto/media/CreateImageRequest';
import ImageResponse from './be/fooda/frontend/customer/data/dto/media/ImageResponse';
import ResponseEntity from './org/springframework/http/ResponseEntity';

function _createFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('MediaClient', 'createFallBack');
}
export {_createFallBack as createFallBack};

function _createImage(
 image: CreateImageRequest | undefined
): Promise<string | undefined> {
 return client.call('MediaClient', 'createImage', {image});
}
export {_createImage as createImage};

function _deleteFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('MediaClient', 'deleteFallBack');
}
export {_deleteFallBack as deleteFallBack};

function _findImageById(
 mediaId: number | undefined
): Promise<ImageResponse | undefined> {
 return client.call('MediaClient', 'findImageById', {mediaId});
}
export {_findImageById as findImageById};

function _findManyFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('MediaClient', 'findManyFallBack');
}
export {_findManyFallBack as findManyFallBack};

function _findSingleFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('MediaClient', 'findSingleFallBack');
}
export {_findSingleFallBack as findSingleFallBack};

function _getImgUrl(): Promise<string | undefined> {
 return client.call('MediaClient', 'getImgUrl');
}
export {_getImgUrl as getImgUrl};

function _updateFallBack(): Promise<ResponseEntity | undefined> {
 return client.call('MediaClient', 'updateFallBack');
}
export {_updateFallBack as updateFallBack};

export const MediaClient = Object.freeze({
  createFallBack: _createFallBack,
  createImage: _createImage,
  deleteFallBack: _deleteFallBack,
  findImageById: _findImageById,
  findManyFallBack: _findManyFallBack,
  findSingleFallBack: _findSingleFallBack,
  getImgUrl: _getImgUrl,
  updateFallBack: _updateFallBack,
});
