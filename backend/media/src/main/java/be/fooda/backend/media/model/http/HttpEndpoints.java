package be.fooda.backend.media.model.http;

public class HttpEndpoints {

    // PAGING_OPTIONS
    public static final int PAGE_SIZE_PER_RESULT = 25;
    public static final int DEFAULT_PAGE_NO = 0;
    public static final String PAGE_NUMBER = "pageNo";
    public static final Integer PAGE_NUMBER_DEFAULT_VALUE = 1;
    public static final String PAGE_SIZE = "pageSize";
    public static final Integer PAGE_SIZE_DEFAULT_VALUE = 50;

    // IMAGE_ENDPOINTS
    public static final String GET_ALL = "find/all";
    public static final String GET_SEARCH = "search";
    public static final String GET_FILTER = "search/filter";
    public static final String POST_SINGLE = "create/one";
    public static final String POST_ALL = "create/many";
    public static final String FIND_BY_ID = "find/one/{id}";
    public static final String GET_EXISTS_BY_ID = "exists/one/{id}";
    public static final String GET_EXISTS_BY_UNIQUE_FIELDS = "exists/unique";
    public static final String PUT_SINGLE = "update/one/{id}";
    public static final String PUT_ALL = "update/many";
    public static final String DELETE_BY_ID = "delete/one/{id}";
    public static final String DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{id}";

    // BARCODE_ENDPOINTS
    public static final String POST_GENERATE_BARCODE = "generate/one";

}
