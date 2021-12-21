// @ts-nocheck

import ImageResponse from './ImageResponse';

import {ObjectModel,StringModel,NumberModel,ArrayModel,BooleanModel,Required,ModelType,_getPropertyModel} from '@vaadin/form';

import {Email,Null,NotNull,NotEmpty,NotBlank,AssertTrue,AssertFalse,Negative,NegativeOrZero,Positive,PositiveOrZero,Size,Past,Future,Digits,Min,Max,Pattern,DecimalMin,DecimalMax} from '@vaadin/form';

/**
 * This module is generated from be.fooda.frontend.customer.data.dto.media.ImageResponse.
 * All changes to this file are overridden. Please consider to make changes in the corresponding Java file if necessary.
 * @see {@link file://C:\Users\intec\.projects\fooda\fooda-frontend-customer\src\main\java\be\fooda\frontend\customer\data\dto\media\ImageResponse.java}
 */
export default class ImageResponseModel<T extends ImageResponse = ImageResponse> extends ObjectModel<T> { 
  static createEmptyValue: () => ImageResponse;

  get altText(): StringModel {
    return this[_getPropertyModel]('altText', StringModel, [true]);
  }

  get createdAt(): StringModel {
    return this[_getPropertyModel]('createdAt', StringModel, [true]);
  }

  get dataAsByte(): ObjectModel {
    return this[_getPropertyModel]('dataAsByte', ObjectModel, [true]);
  }

  get extension(): StringModel {
    return this[_getPropertyModel]('extension', StringModel, [true]);
  }

  get height(): NumberModel {
    return this[_getPropertyModel]('height', NumberModel, [true]);
  }

  get imageId(): NumberModel {
    return this[_getPropertyModel]('imageId', NumberModel, [true]);
  }

  get isActive(): BooleanModel {
    return this[_getPropertyModel]('isActive', BooleanModel, [true]);
  }

  get isPublic(): BooleanModel {
    return this[_getPropertyModel]('isPublic', BooleanModel, [true]);
  }

  get isResponsive(): BooleanModel {
    return this[_getPropertyModel]('isResponsive', BooleanModel, [true]);
  }

  get isVisible(): BooleanModel {
    return this[_getPropertyModel]('isVisible', BooleanModel, [true]);
  }

  get relatedId(): NumberModel {
    return this[_getPropertyModel]('relatedId', NumberModel, [true]);
  }

  get type(): StringModel {
    return this[_getPropertyModel]('type', StringModel, [true]);
  }

  get updatedAt(): StringModel {
    return this[_getPropertyModel]('updatedAt', StringModel, [true]);
  }

  get url(): StringModel {
    return this[_getPropertyModel]('url', StringModel, [true]);
  }

  get userId(): NumberModel {
    return this[_getPropertyModel]('userId', NumberModel, [true]);
  }

  get width(): NumberModel {
    return this[_getPropertyModel]('width', NumberModel, [true]);
  }
}
