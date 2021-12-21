package be.fooda.cloud.converter.view.controller;

import be.fooda.cloud.converter.model.ConvertibleMediaTypes;
import be.fooda.cloud.converter.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/convert/product")
public class ProductController {

    @PostMapping(value = "/csv2json", consumes = ConvertibleMediaTypes.TEXT_CSV_VALUE, produces = ConvertibleMediaTypes.APPLICATION_JSON_VALUE)
    public List<Product> csv2json(@RequestBody Product.Data products) {
        return products.getList();
    }

    @PostMapping(value = "/json2csv", consumes = ConvertibleMediaTypes.APPLICATION_JSON_VALUE, produces = ConvertibleMediaTypes.TEXT_CSV_VALUE)
    public Product.Data json2csv(@RequestBody List<Product> products) {
        Product.Data data = new Product.Data();
        data.setList(products);
        return data;
    }

    @PostMapping(value = "/yaml2json", consumes = ConvertibleMediaTypes.TEXT_YAML_VALUE, produces = ConvertibleMediaTypes.APPLICATION_JSON_VALUE)
    public List<Product> yaml2json(@RequestBody Product.Data products) {
        return products.getList();
    }

    @PostMapping(value = "/json2yaml", consumes = ConvertibleMediaTypes.APPLICATION_JSON_VALUE, produces = ConvertibleMediaTypes.TEXT_YAML_VALUE)
    public Product.Data json2yaml(@RequestBody List<Product> products) {
        Product.Data data = new Product.Data();
        data.setList(products);
        return data;
    }

    @PostMapping(value = "/xml2json", consumes = ConvertibleMediaTypes.APPLICATION_XML_VALUE, produces = ConvertibleMediaTypes.APPLICATION_JSON_VALUE)
    public List<Product> xml2json(@RequestBody List<Product> products) {
        return products;
    }

    @PostMapping(value = "/json2xml", consumes = ConvertibleMediaTypes.APPLICATION_JSON_VALUE, produces = ConvertibleMediaTypes.APPLICATION_XML_VALUE)
    public List<Product> json2xml(@RequestBody List<Product> products) {
        return products;
    }
}