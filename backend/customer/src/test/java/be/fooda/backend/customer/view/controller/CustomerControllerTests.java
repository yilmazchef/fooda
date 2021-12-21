//package be.fooda.backend.customer.view.controller;
//
//import be.fooda.backend.customer.model.dto.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//// JUNIT_5, JUNIT_JUPITER
//// mvn clean < compile < test < install (.jar)
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//public class CustomerControllerTests {
//
//    @LocalServerPort
//    int port;
//
//    @Autowired
//    private TestRestTemplate rest;
//
//    @Test
//    void shouldCreate() throws URISyntaxException {
//
//        //init...
//        final var baseUrl = "http//localhost:" + port;
//        final var createUrl = baseUrl + "/api/v2/customers/create/one/";
//        final var uri = new URI(createUrl);
//
//        final var customer = getCreateRequest();
//
//        //flow...
//        final var headers = new HttpHeaders();
//        final var request = new HttpEntity<>(customer,headers);
//        final var response = rest.exchange(uri, HttpMethod.POST, request, String.class); // Todo: URI is not absolute
//
//        //assertions (compare and validate)
//        Assertions.assertEquals(201,response.getStatusCodeValue());
//        Assertions.assertEquals("Customer CREATED based on the given information" , response.getBody());
//    }
//
//    private CreateCustomerRequest getCreateRequest() {
//
//        final var customer = new CreateCustomerRequest();
//        customer.setAddressId(123L);
//        customer.setContactId(456L);
//        customer.setDateOfBirth("16/04/1985");
//        customer.setFamilyName("Bond");
//        customer.setFirstName("James");
//        customer.setId(7L);
//        customer.setIsActive(true);
//        customer.setNote("a Note");
//        customer.setUserId(17L);
//
//        Set<Long> favoriteOrders = new LinkedHashSet<>();
//        favoriteOrders.add(15L);
//        favoriteOrders.add(47L);
//        customer.setFavoriteOrders(favoriteOrders);
//
//        customer.setValidation("Yes");
//
//        return customer;
//    }
//
//    @Test
//    void shouldUpdateOnlyFirstNameByCustomerId() throws URISyntaxException {
//
//        //init...
//        final var baseUrl = "http://localhost:" + port;
//        final var customerId = 1L;
//        final var createUrl = baseUrl +  "/api/v2/customers/create/one/";
//        final var createUri = new URI(createUrl);
//        final var updateUrl = baseUrl +  "/api/v2/customers/update/one/"+ customerId;
//        final var updateUri = new URI(updateUrl);
//
//        final var customerToCreate = getCreateRequest();
//
//        // flow to create ..
//        final var createHeaders = new HttpHeaders();
//        final var createRequest = new HttpEntity<>(customerToCreate, createHeaders);
//        final var createResponse = rest.postForEntity(createUri, createRequest, String.class);
//
//        // init..
//        final HttpHeaders headersFromUpdateResponse = createResponse.getHeaders();
//        final var customerIdToUpdate = Long.valueOf( headersFromUpdateResponse.getFirst("saved_id"));
//        final var customerToUpdate = getUpdateRequestForFirstName("Ali");
//
//        // flow to update ..
//        final var updateHeaders = new HttpHeaders();
//        final var updateRequest = new HttpEntity<>(customerToUpdate, updateHeaders);
//        final var updateResponse = rest.exchange(updateUri, HttpMethod.PUT, updateRequest, String.class);
//
//        // assertions (compare & validate) ..
//        Assertions.assertEquals(202, updateResponse.getStatusCode()); // Todo:404 Not Found
//        Assertions.assertEquals("Customer successfully updated", updateResponse.getBody());
//    }
//
//    private UpdateCustomerRequest getUpdateRequestForFirstName(String firstName){
//
//        final var customer = new UpdateCustomerRequest();
//        customer.setFirstName(firstName);
//
//        return customer;
//    }
//
//    private UpdateCustomerRequest getUpdateRequestForNote(String note){
//
//        final var customer = new UpdateCustomerRequest();
//        customer.setNote("Second Note");
//
//        return customer;
//    }
//
//    @Test
//    void shouldFindById()  {
//
//    }
//
//    @Test
//    void shouldFindAll() {
//
//    }
//
//    @Test
//    void shouldDelete() {
//
//    }
//}
