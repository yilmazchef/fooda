package be.fooda.backend.product.view.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import be.fooda.backend.product.model.dto.*;

// JUNIT_5, JUNIT_JUPITER
// mvn clean < compile < test < install (.jar) 


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTests {

    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate rest;

    
    void shouldCreate() throws URISyntaxException{

            // init.. 

            final var baseUrl = "http://localhost:" + port;
            final var createUrl = baseUrl + "/api/v2/products/create/one/";
            final var uri = new URI(createUrl);

            final var product = getCreateRequest();

            // flow ..
            final var headers = new HttpHeaders();
            final var request = new HttpEntity<>(product, headers);
            final var response = rest.exchange(uri, HttpMethod.POST, request, String.class);
        

            // assertions (compare & validate) ..
            Assertions.assertEquals(201, response.getStatusCodeValue());
            Assertions.assertEquals("Product is created based on the given information", response.getBody());

    }

    void shouldUpdateOnlyTitleByProductId() throws URISyntaxException{

         // init.. 

         final var baseUrl = "http://localhost:" + port;
         final var productId = 1;
         final var createUrl = baseUrl + "/api/v2/products/create/one/";
         final var createUri = new URI(createUrl);
         final var updateUrl = baseUrl + "/api/v2/products/update/one/" + productId;
         final var updateUri = new URI(updateUrl);

        final var productToCreate = getCreateRequest();

         // flow to create ..
         final var createHeaders = new HttpHeaders();
         final var createRequest = new HttpEntity<>(productToCreate, createHeaders);
         final var createResponse = rest.postForEntity(createUri, createRequest, String.class);

         // init.. 
        final var productIdToUpdate = Long.valueOf(createResponse.getHeaders().get("saved_id").get(0));
        final var productToUpdate = getUpdateRequestForTitle("Pizza Hawai");

        // flow to update ..
        final var updateHeaders = new HttpHeaders();
        final var updateRequest = new HttpEntity<>(productToUpdate, updateHeaders);
        final var updateResponse = rest.exchange(updateUri, HttpMethod.PUT, updateRequest, String.class);

         // assertions (compare & validate) ..
         Assertions.assertEquals(202, updateResponse.getStatusCode());
         Assertions.assertEquals("Product successfully updated", updateResponse.getBody());

    }

    private CreateProductRequest getCreateRequest(){

        final var product = new CreateProductRequest();
        product.setDefaultImageId(321L);
        product.setDescription("The best pizza in town.. Students' choice.");
        product.setIsFeatured(true);
        product.setLimitPerOrder(100);
        product.setStoreId(11L);
        product.setTitle("Pizza Margherita");
        product.setType(CreateTypeRequest.SIMPLE);

        final var category1 = new CreateCategoryRequest();
        category1.setTitle("pizza");

        final var category2 = new CreateCategoryRequest();
        category2.setTitle("vegan");

        product.addCategory(category1);
        product.addCategory(category2);


        final var ingredient1 = new CreateIngredientRequest();
        ingredient1.setTitle("tomatoes");
        ingredient1.setPrice(BigDecimal.valueOf(0.50));


        final var ingredient2 = new CreateIngredientRequest();
        ingredient2.setTitle("buffalo mozzarella");
        ingredient2.setPrice(BigDecimal.valueOf(1.25));

        product.addIngredient(ingredient1);
        product.addIngredient(ingredient2);

        final var price1 = new CreatePriceRequest();
        price1.setTitle("Default Price");
        price1.setAmount(BigDecimal.valueOf(12.50));

        final var price2 = new CreatePriceRequest();
        price2.setTitle("Student Price");
        price2.setAmount(BigDecimal.valueOf(9.00));

        product.addPrice(price1);
        product.addPrice(price2);

        final var tag1 = new CreateTagRequest();
        tag1.setValue("pizza");

        final var tag2 = new CreateTagRequest();
        tag2.setValue("vegetarian");

        final var tag3 = new CreateTagRequest();
        tag3.setValue("student");

        final var tag4 = new CreateTagRequest();
        tag4.setValue("mozzarella");
        

        product.addTag(tag1);
        product.addTag(tag2);
        product.addTag(tag3);
        product.addTag(tag4);

        final var tax1 = new CreateTaxRequest();
        tax1.setTitle("Default Tax");
        tax1.setPercentage(0.21);
        tax1.setIsDefault(true);

        product.addTax(tax1);

        return product;
    }

    private UpdateProductRequest getUpdateRequestForTitle(String title){

        final var product = new UpdateProductRequest();
        product.setTitle(title);

        return product;
    }

    private UpdateProductRequest getUpdateRequestAddPrice(UpdatePriceRequest price){

        final var product = new UpdateProductRequest();
        product.addPrice(price);

        return product;
    }

    private UpdateProductRequest getUpdateRequestForAddCategory(UpdateCategoryRequest category){

        final var product = new UpdateProductRequest();
        product.addCategories(category);

        return product;
    }


    
}
