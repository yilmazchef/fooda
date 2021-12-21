package be.fooda.cloud.converter.model;

import org.springframework.http.MediaType;

public class ConvertibleMediaTypes extends MediaType {

    public static final MediaType TEXT_CSV = new MediaType("text/csv");
    public static final String TEXT_CSV_VALUE = "text/csv";

    public static final MediaType TEXT_YAML = new MediaType("text/yaml");
    public static final String TEXT_YAML_VALUE = "text/yaml";

    public ConvertibleMediaTypes(String type) {
        super(type);
    }

}

