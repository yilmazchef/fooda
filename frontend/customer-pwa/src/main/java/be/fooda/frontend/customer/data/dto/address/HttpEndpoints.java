package be.fooda.frontend.customer.data.dto.address;

public class HttpEndpoints {

    // PAGING DEFAULTS
    public static final String PAGE_NUMBER_TEXT = "pageNo";
    public static final String PAGE_SIZE_TEXT = "pageSize";
    public static final String PAGE_NUMBER_DEFAULT_VALUE = "1";
    public static final String PAGE_SIZE_DEFAULT_VALUE = "50";

    // ADDRESS_ENDPOINTS
    public static final String ADDRESSS_FIND_ALL_TEXT = "find/all/";
    public static final String ADDRESSS_FIND_ALL_BY_USER_ID_TEXT = "find/all/user/{userId}";
    public static final String ADDRESSS_SEARCH_TEXT = "search/{keyword}";
    public static final String ADDRESSS_POST_SINGLE_TEXT = "create/one/";
    public static final String ADDRESSS_FIND_BY_ID_TEXT = "find/one/{addressId}";
    public static final String ADDRESSS_FIND_EXISTS_BY_ID_TEXT = "exists/one/{addressId}";
    public static final String ADDRESS_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String ADDRESSS_PUT_SINGLE_TEXT = "update/one/{addressId}";
    public static final String ADDRESSS_DELETE_BY_ID = "delete/one/passive/{addressId}";
    public static final String ADDRESSS_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{addressId}";

}
