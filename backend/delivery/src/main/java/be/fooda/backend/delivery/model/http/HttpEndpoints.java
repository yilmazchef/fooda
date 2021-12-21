package be.fooda.backend.delivery.model.http;

public class HttpEndpoints {
    // PAGING DEFAULTS
    public static final String PAGE_NUMBER_TEXT = "pageNo";
    public static final String PAGE_SIZE_TEXT = "pageSize";
    public static final String PAGE_NUMBER_DEFAULT_VALUE = "1";
    public static final String PAGE_SIZE_DEFAULT_VALUE = "50";

    public static final String PAGE_SIZE = "pageSize";
    public static final String GET_ALL = "get/all";
    public static final String GET_SEARCH = "search";
    public static final String GET_FILTER = "filter";
    public static final String POST_SINGLE = "add/one";
    public static final String POST_ALL = "add/all";
    public static final String GET_BY_ID = "get/one/{deliveryId}";
    public static final String GET_EXISTS_BY_ID = "exists/one/{deliveryId}";
    public static final String GET_EXISTS_BY_UNIQUE_FIELDS = "exists/unique";
    public static final String PUT_SINGLE = "edit/one/{deliveryId}";
    public static final String PUT_ALL = "edit/all";
    public static final String DELETE_BY_ID = "delete/one/{deliveryId}";
    public static final String DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{deliveryId}";
}
