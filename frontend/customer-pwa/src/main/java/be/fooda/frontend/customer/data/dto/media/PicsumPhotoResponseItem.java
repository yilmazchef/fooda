package be.fooda.frontend.customer.data.dto.media;

import lombok.Data;

public @Data class PicsumPhotoResponseItem{
	private String author;
	private Integer width;
	private String downloadUrl;
	private String id;
	private String url;
	private Integer height;
}