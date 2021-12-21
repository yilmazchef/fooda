package be.fooda.cloud.converter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Product implements Serializable {

    @CsvBindByName
    @JsonProperty("id")
    @XmlElement
    private Long id;

    @CsvBindByName
    @JsonProperty("storeId")
    @XmlElement
    private Long storeId;

    @CsvBindByName
    @JsonProperty("name")
    @XmlElement
    private String name;

    @CsvBindByName
    @JsonProperty("desc")
    @XmlElement
    private String desc;

    @CsvBindByName
    @JsonProperty("price")
    @XmlElement
    private Double price;

    @CsvBindByName
    @JsonProperty("imgUrl")
    @XmlElement
    private String imgUrl;

    @CsvBindByName
    @JsonProperty("stock")
    @XmlElement
    private int stock;

    public static class Data extends ListParam<Product> {

    }
}