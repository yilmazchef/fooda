package be.fooda.backend.payment.model.http;

public class HttpEndpoints {

    // PAGING DEFAULTS
    public static final String PAGE_NUMBER_TEXT = "pageNo";
    public static final String PAGE_SIZE_TEXT = "pageSize";
    public static final String PAGE_NUMBER_DEFAULT_VALUE = "1";
    public static final String PAGE_SIZE_DEFAULT_VALUE = "50";

    // PAYMENT_ENDPOINTS
    public static final String PAYMENTS_FIND_ALL_TEXT = "find/all/";
    public static final String PAYMENTS_SEARCH_TEXT = "search/{keyword}";
    public static final String PAYMENTS_POST_SINGLE_TEXT = "create/one/";
    public static final String PAYMENTS_POST_MANY_TEXT = "create/many/";
    public static final String PAYMENTS_FIND_BY_ID_TEXT = "find/one/{paymentId}";
    public static final String PAYMENTS_FIND_EXISTS_BY_ID_TEXT = "exists/one/{paymentId}";
    public static final String PAYMENT_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String PAYMENTS_PUT_SINGLE_TEXT = "update/one/{paymentId}";
    public static final String PAYMENTS_DELETE_BY_ID_MAKE_PASSIVE = "delete/one/passive/{paymentId}";
    public static final String PAYMENTS_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{paymentId}";
    
    // INGREDIENT_ENDPOINTS
    public static final String INGREDIENTS_FIND_ALL_BY_PAYMENT_ID_TEXT = "find/{paymentId}/all/";
    public static final String INGREDIENTS_FIND_DEFAULT_BY_PAYMENT_ID_TEXT = "find/default/{paymentId}";
    public static final String INGREDIENTS_POST_SINGLE_TEXT = "create/one/";
    public static final String INGREDIENTS_FIND_BY_ID_TEXT = "find/one/{priceId}";
    public static final String INGREDIENTS_FIND_EXISTS_BY_ID_TEXT = "exists/one/{priceId}";
    public static final String INGREDIENT_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String INGREDIENT_PUT_SINGLE = "update/one/{priceId}";
    public static final String INGREDIENT_DELETE_BY_ID = "delete/one/passive/{priceId}";
    public static final String INGREDIENT_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{priceId}";
    
    // PRICE_ENDPOINTS
    public static final String PRICES_FIND_ALL_BY_PAYMENT_ID_TEXT = "find/{paymentId}/all/";
    public static final String PRICES_FIND_DEFAULT_BY_PAYMENT_ID_TEXT = "find/default/{paymentId}";
    public static final String PRICES_POST_SINGLE_TEXT = "create/one/";
    public static final String PRICES_FIND_BY_ID_TEXT = "find/one/{priceId}";
    public static final String PRICES_FIND_EXISTS_BY_ID_TEXT = "exists/one/{priceId}";
    public static final String PRICE_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String PRICE_PUT_SINGLE = "update/one/{priceId}";
    public static final String PRICE_DELETE_BY_ID = "delete/one/passive/{priceId}";
    public static final String PRICE_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{priceId}";

    // CATEGORY_ENDPOINTS
    public static final String CATEGORIES_FIND_ALL_BY_PAYMENT_ID_TEXT = "find/{paymentId}/all/";
    public static final String CATEGORIES_FIND_DEFAULT_BY_PAYMENT_ID_TEXT = "find/default/{paymentId}";
    public static final String CATEGORIES_POST_SINGLE_TEXT = "create/one/";
    public static final String CATEGORIES_FIND_BY_ID_TEXT = "find/one/{categoryId}";
    public static final String CATEGORIES_FIND_EXISTS_BY_ID_TEXT = "exists/one/{categoryId}";
    public static final String CATEGORY_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String CATEGORY_PUT_SINGLE = "update/one/{categoryId}";
    public static final String CATEGORY_DELETE_BY_ID = "delete/one/passive/{categoryId}";
    public static final String CATEGORY_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{categoryId}";

    // TAG_ENDPOINTS
    public static final String TAGS_FIND_ALL_BY_PAYMENT_ID_TEXT = "find/{paymentId}/all/";
    public static final String TAGS_FIND_DEFAULT_BY_PAYMENT_ID_TEXT = "find/default/{paymentId}";
    public static final String TAGS_POST_SINGLE_TEXT = "create/one/";
    public static final String TAGS_FIND_BY_ID_TEXT = "find/one/{tagId}";
    public static final String TAGS_FIND_EXISTS_BY_ID_TEXT = "exists/one/{tagId}";
    public static final String TAG_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String TAG_PUT_SINGLE = "update/one/{tagId}";
    public static final String TAG_DELETE_BY_ID = "delete/one/passive/{tagId}";
    public static final String TAG_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{tagId}";

    // TAX_ENDPOINTS
    public static final String TAXES_FIND_ALL_BY_PAYMENT_ID_TEXT = "find/{paymentId}/all/";
    public static final String TAXES_FIND_DEFAULT_BY_PAYMENT_ID_TEXT = "find/default/{paymentId}";
    public static final String TAXES_POST_SINGLE_TEXT = "create/one/";
    public static final String TAXES_FIND_BY_ID_TEXT = "find/one/{taxId}";
    public static final String TAXES_FIND_EXISTS_BY_ID_TEXT = "exists/one/{taxId}";
    public static final String TAX_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String TAX_PUT_SINGLE = "update/one/{taxId}";
    public static final String TAX_DELETE_BY_ID = "delete/one/passive/{taxId}";
    public static final String TAX_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{taxId}";

}
