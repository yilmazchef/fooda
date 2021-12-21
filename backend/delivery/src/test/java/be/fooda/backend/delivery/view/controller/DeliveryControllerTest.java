package be.fooda.backend.delivery.view.controller;

import be.fooda.backend.delivery.model.DeliveryStatus;
import be.fooda.backend.delivery.model.dto.CreateDeliveryRequest;
import be.fooda.backend.delivery.model.dto.UpdateDeliveryRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DeliveryControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate rest;



  /*  @BeforeEach
    void setUp() throws URISyntaxException {
        final var baseUrl = "http://localhost:" + port;
        final var createUrl = baseUrl + "/api/v2/products/create/one/";
        final var uri = new URI(createUrl);

        final var product = getCreateRequest();

        // flow ..
        final var headers = new HttpHeaders();
        final var request = new HttpEntity<>(product, headers);
        final var response = rest.exchange(uri, HttpMethod.POST, request, String.class);
    }*/

    //@Test
    void create() throws URISyntaxException {
        // init..

        final var baseUrl = "http://localhost:" + port;
        final var createUrl = baseUrl + "/api/v2/delivery/create/one/";
        final var uri = new URI(createUrl);

        final var delivery = getCreateRequest();

        // flow ..
        final var headers = new HttpHeaders();
        final var request = new HttpEntity<>(delivery, headers);
        final var response = rest.exchange(uri, HttpMethod.POST, request, String.class);


        // assertions (compare & validate) ..
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Delivery is created based on the given information", response.getBody());
    }

    //@Test
    void update() throws URISyntaxException {

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
        final var deliveryIdToUpdate = Long.valueOf(createResponse.getHeaders().get("saved_id").get(0));
        final var deliveryToUpdate = getUpdateRequestForNote("This is a test");

        // flow to update ..
        final var updateHeaders = new HttpHeaders();
        final var updateRequest = new HttpEntity<>(deliveryToUpdate, updateHeaders);
        final var updateResponse = rest.exchange(updateUri, HttpMethod.PUT, updateRequest, String.class);

        // assertions (compare & validate) ..
        assertEquals(202, updateResponse.getStatusCode());
        assertEquals("Product successfully updated", updateResponse.getBody());
    }

    private UpdateDeliveryRequest getUpdateRequestForNote(String note) {

        final var updateDeliveryRequest = new UpdateDeliveryRequest();
        updateDeliveryRequest.setNote(note);

        return updateDeliveryRequest;
    }

    //@Test
    void deleteById() {
    }

   // @Test
    void deleteByIdPermanently() {
    }

    //@Test
    void findAll() {
    }

   // @Test
    void findById() {
    }

   // @Test
    void search() {
    }

    //@Test
    void existsById() {
    }

    //@Test
    void existsByUniqueFields() {
    }

    private CreateDeliveryRequest getCreateRequest(){

        final var delivery = new CreateDeliveryRequest();
        delivery.setTrackingId("TRACKINGID");
        delivery.setCourierId(1L);
        delivery.setNote("This is a delivery");
        delivery.setOrderId(2L);
        delivery.setStatus(DeliveryStatus.ON_DELIVERY_SUCCESS);
        delivery.setStoreId(3L);
        delivery.setCustomerId(4L);
        return delivery;
    }
}