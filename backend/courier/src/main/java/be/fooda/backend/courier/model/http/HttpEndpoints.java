package be.fooda.backend.courier.model.http;

public class HttpEndpoints {

    // PAGING DEFAULTS
    public static final String PAGE_NUMBER_TEXT = "pageNo";
    public static final String PAGE_SIZE_TEXT = "pageSize";
    public static final String PAGE_NUMBER_DEFAULT_VALUE = "1";
    public static final String PAGE_SIZE_DEFAULT_VALUE = "50";

    // ADDRESS_ENDPOINTS
    public static final String ADDRESSS_FIND_ALL_TEXT = "find/all/";
    public static final String ADDRESSS_SEARCH_TEXT = "search/{keyword}";
    public static final String ADDRESSS_POST_SINGLE_TEXT = "create/one/";
    public static final String ADDRESSS_FIND_BY_ID_TEXT = "find/one/{addressId}";
    public static final String ADDRESSS_FIND_EXISTS_BY_ID_TEXT = "exists/one/{addressId}";
    public static final String ADDRESS_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String ADDRESSS_PUT_SINGLE_TEXT = "update/one/{addressId}";
    public static final String ADDRESSS_DELETE_BY_ID = "delete/one/passive/{addressId}";
    public static final String ADDRESSS_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{addressId}";

    // PRICE_ENDPOINTS
    public static final String PRICES_FIND_ALL_BY_ADDRESS_ID_TEXT = "find/{addressId}/all/";
    public static final String PRICES_FIND_DEFAULT_BY_ADDRESS_ID_TEXT = "find/default/{addressId}";
    public static final String PRICES_POST_SINGLE_TEXT = "create/one/";
    public static final String PRICES_FIND_BY_ID_TEXT = "find/one/{priceId}";
    public static final String PRICES_FIND_EXISTS_BY_ID_TEXT = "exists/one/{priceId}";
    public static final String PRICE_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String PRICE_PUT_SINGLE = "update/one/{priceId}";
    public static final String PRICE_DELETE_BY_ID = "delete/one/passive/{priceId}";
    public static final String PRICE_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{priceId}";

    //COURIER_ENDPOINTS
    public static final String CREATE_A_COURIER = "/create/one";
    public static final String GET_BY_ID = "/find/one/{courierId}";
    public static final String GET_ALL_COURIER = "/find/all";
    public static final String UPDATE_BY_ID = "/update/one/{courierId}";
    public static final String DELETE_BY_ID = "/delete/one/{courierId}";
    public static final String EXISTS_BY_ID = "/exists/one/{courierId}";
    public static final String EXISTS_BY_UNIQUE_FIELDS = "/exists/unique";
    public static final String COURIER_SEARCH_TEXT = "search/{keyword}";
    public static final String GET_ALL_BY_USER_ID = "find/user/{userId}";


}
