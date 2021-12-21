package be.fooda.backend.contact.model.http;

public class HttpEndpoints {

    // PAGING DEFAULTS
    public static final String PAGE_NUMBER_TEXT = "pageNo";
    public static final String PAGE_SIZE_TEXT = "pageSize";
    public static final String PAGE_NUMBER_DEFAULT_VALUE = "1";
    public static final String PAGE_SIZE_DEFAULT_VALUE = "50";

    // Contact_ENDPOINTS
    public static final String CONTACT_FIND_ALL_TEXT = "find/all/";
    public static final String CONTACT_SEARCH_TEXT = "search/{keyword}";
    public static final String CONTACT_POST_SINGLE_TEXT = "create/one/";
    public static final String CONTACT_FIND_BY_ID_TEXT = "find/one/{contactId}";
    public static final String CONTACT_FIND_EXISTS_BY_ID_TEXT = "exists/one/{contactId}";
    public static final String Contact_EXISTS_BY_UNIQUE_FIELDS = "exists/one/unique/";
    public static final String CONTACTS_PUT_SINGLE_TEXT = "update/one/{contactId}";
    public static final String CONTACT_DELETE_BY_ID = "delete/one/passive/{contactId}";
    public static final String CONTACT_DELETE_BY_ID_PERMANENTLY = "delete/one/permanent/{contactId}";
    
}
