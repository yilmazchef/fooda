package be.fooda.backend.review.model.http;

public class HttpEndpoints {

    public static final String PAGE_NUMBER_TEXT = "pageNo";
    public static final String PAGE_NUMBER_DEFAULT_VALUE = "1";
    public static final String PAGE_SIZE_TEXT = "pageSize";
    public static final String PAGE_SIZE_DEFAULT_VALUE = "50";
    public static final String GET_ALL = "find/all/";
    public static final String GET_ALL_BY_CUSTOMER = "find/allByCustomer/";
    public static final String GET_ALL_BY_STORE = "find/allByStore/";
    public static final String GET_ALL_BY_CUSTOMER_AND_STORE = "find/allByCustomerAndStore/";
    public static final String GET_SEARCH_TEXT = "search/";
    public static final String GET_FILTER = "filter/";
    public static final String POST_SINGLE = "add/one/";
    public static final String POST_ALL = "add/all/";
    public static final String GET_BY_ID = "find/one/";
    public static final String GET_EXISTS_BY_ID = "exists/one/";
    public static final String GET_EXISTS_BY_UNIQUE_FIELDS = "exists/unique/";
    public static final String PUT_SINGLE_BY_ID = "edit/one/id/";
    public static final String PUT_SINGLE_BY_SESSION = "edit/one/session/";
    public static final String PATCH_SINGLE = "patch/one/";
    public static final String PUT_ALL = "edit/all/";
    public static final String DELETE_BY_ID = "delete/one/";
    public static final String DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/";
    public static final String GET_BY_CUSTOMER_AND_STORE ="find/unique/" ;
    public static final String GET_BY_SESSION_AND_STORE = "find/session-and-store/";
    public static final String GET_BY_SESSION = "find/session/";
}
