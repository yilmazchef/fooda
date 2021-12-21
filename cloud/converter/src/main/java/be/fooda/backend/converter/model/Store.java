package be.fooda.cloud.converter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Store {

    @CsvBindByName
    @JsonProperty("id")
    @XmlElement
    private Long id;

    @CsvBindByName
    @JsonProperty("name")
    @XmlElement
    private String name;

    @CsvBindByName
    @JsonProperty("url")
    @XmlElement
    private String url;

    @CsvBindByName
    @JsonProperty("key")
    @XmlElement
    private String key;

    @CsvBindByName
    @JsonProperty("secret")
    @XmlElement
    private String secret;

    public static class Data extends ListParam<Store> {

    }
}
