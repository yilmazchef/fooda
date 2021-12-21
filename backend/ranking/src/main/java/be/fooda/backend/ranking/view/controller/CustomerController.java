package be.fooda.backend.ranking.view.controller;

import be.fooda.backend.ranking.dao.CustomerRepository;
import be.fooda.backend.ranking.model.dto.CreateCustomerRequest;
import be.fooda.backend.ranking.model.dto.CustomerResponse;
import be.fooda.backend.ranking.model.dto.UpdateCustomerRequest;
import be.fooda.backend.ranking.model.http.HttpEndpoints;
import be.fooda.backend.ranking.model.http.HttpFailureMessages;
import be.fooda.backend.ranking.model.http.HttpSuccessMessages;
import be.fooda.backend.ranking.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v2/ranking/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    // CREATING_NEW_CUSTOMER_RANKING
    @PostMapping(HttpEndpoints.POST_SINGLE)
    public ResponseEntity<CustomerResponse> create(@RequestBody @NotNull CreateCustomerRequest request) {

        if (customerRepository.existsBySession(request.getSession())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpFailureMessages.CUSTOMER_RANKING_EXIST_CANNOT_BE_CREATED.getDescription());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerMapper.toResponse(
                        customerRepository.save(customerMapper.toDocument(request))
                ));
    }

    // UPDATE_SINGLE_CUSTOMER_RANKING
    @PutMapping(HttpEndpoints.PUT_SINGLE_BY_ID)
    public ResponseEntity<CustomerResponse> updateById(@RequestParam("customerId") @NotNull String customerId,
                                             @RequestBody @NotNull UpdateCustomerRequest request) {

        return customerRepository
                .findById(new String(customerId))
                .map(customerDocument -> customerMapper.toDocument(request, customerDocument))
                .map(customerDocument -> customerRepository.save(customerDocument))
                .map(customerDocument -> customerMapper.toResponse(customerDocument))
                .map(customerResponse -> ResponseEntity.status(HttpStatus.ACCEPTED).body(customerResponse))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.ACCEPTED, HttpFailureMessages.CUSTOMER_RANKING_EXIST_CANNOT_BE_UPDATED.getDescription());
                });
    }

    // UPDATE_SINGLE_CUSTOMER_RANKING
    @PutMapping(HttpEndpoints.PUT_SINGLE_BY_SESSION)
    public ResponseEntity<CustomerResponse> updateBySession(@RequestParam("session") @NotNull String session,
                                                       @RequestBody @NotNull UpdateCustomerRequest request) {

        return customerRepository
                .findBySession(session)
                .map(customerDocument -> customerMapper.toDocument(request, customerDocument))
                .map(customerDocument -> customerRepository.save(customerDocument))
                .map(customerDocument -> customerMapper.toResponse(customerDocument))
                .map(customerResponse -> ResponseEntity.status(HttpStatus.ACCEPTED).body(customerResponse))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.ACCEPTED, HttpFailureMessages.CUSTOMER_RANKING_EXIST_CANNOT_BE_UPDATED.getDescription());
                });
    }

    // MAKE_PASSIVE
    @DeleteMapping(HttpEndpoints.DELETE_BY_ID)
    public ResponseEntity<CustomerResponse> deleteByIdMakePassive(@RequestParam("customerId") @NotNull String customerId) {

        return customerRepository
                .findById(customerId)
                .map(customerDocument -> {
                    customerDocument.setActive(false);
                    return customerRepository.save(customerDocument);
                })
                .map(customerDocument -> customerMapper.toResponse(customerDocument))
                .map(customerResponse -> ResponseEntity.status(HttpStatus.ACCEPTED).body(customerResponse))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.ACCEPTED, HttpFailureMessages.CUSTOMER_RANKING_EXIST_CANNOT_BE_UPDATED.getDescription());
                });
    }

    // DELETE_BY_ID
    @DeleteMapping(HttpEndpoints.DELETE_BY_ID_PERMANENTLY)
    public ResponseEntity<String> deleteByIdPermanently(@RequestParam("customerId") @NotNull String customerId) {

        return customerRepository
                .findById(new String(customerId))
                .map(entity -> {
                    customerRepository.deleteById(new String(customerId));
                    return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .body(HttpSuccessMessages.CUSTOMER_RANKING_DELETED.getDescription());
                })
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.CUSTOMER_RANKING_NOT_FOUND.getDescription());
                });
    }

    // @PatchMapping // UPDATE CUSTOMER_RANKING(S) BUT NOT ALL THE FIELDS

    // GET_ALL
    @GetMapping(HttpEndpoints.GET_ALL)
    public ResponseEntity<?> findAll(@RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
                                     @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        customerRepository
                                .findAll(PageRequest.of(pageNo - 1, pageSize))
                                .stream()
                                .map(customerDocument -> customerMapper.toResponse(customerDocument))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // GET_BY_ID
    @GetMapping(HttpEndpoints.GET_BY_ID)
    public ResponseEntity<?> findById(@RequestParam("customerId") @NotNull String customerId) {

        return customerRepository
                .findById(new String(customerId))
                .map(customerDocument -> customerMapper.toResponse(customerDocument))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.CUSTOMER_RANKING_NOT_FOUND.getDescription());
                });
    }

    @GetMapping(HttpEndpoints.GET_BY_SESSION)
    public ResponseEntity<CustomerResponse> findBySession(@RequestParam("session") @NotNull String session) {

        return customerRepository
                .findBySession(session)
                .map(customerDocument -> customerMapper.toResponse(customerDocument))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.CUSTOMER_RANKING_NOT_FOUND.getDescription());
                });
    }

    // TODO: for review module, will be deleted after the code is cloned to review .
    // SEARCH(KEYWORD)
//    @GetMapping(HttpEndpoints.GET_SEARCH)
//    public ResponseEntity<List<CustomerResponse>> search(
//            @PathVariable("comment") @NotNull String comment,
//            @RequestParam(
//                    value = HttpEndpoints.PAGE_NUMBER_TEXT,
//                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
//            @RequestParam(
//                    value = HttpEndpoints.PAGE_SIZE_TEXT,
//                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {
//
//        // FLOW_AND_RETURN
//        return ResponseEntity
//                .status(HttpStatus.FOUND)
//                .body(
//                        customerRepository
//                                .findAllByCommentContaining(comment, PageRequest.of(pageNo - 1, pageSize))
//                                .stream()
//                                .map(customerDocument -> customerMapper.toResponse(customerDocument))
//                                .collect(Collectors.toUnmodifiableList())
//                );
//    }

    // EXISTS_BY_ID
    @GetMapping(HttpEndpoints.GET_EXISTS_BY_ID)
    public ResponseEntity<String> existsById(@RequestParam("customerId") @NotNull String customerId) {

        return customerRepository.existsById(new String(customerId))
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.CUSTOMER_RANKING_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.CUSTOMER_RANKING_DOES_NOT_EXIST.getDescription());
    }

    // EXISTS_BY_UNIQUE_FIELDS
    @GetMapping(HttpEndpoints.GET_EXISTS_BY_UNIQUE_FIELDS)
    public ResponseEntity<String> existsByUniqueFields(@RequestParam("firstNamsession") @NotNull String session) {

        return customerRepository.existsBySession(session)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.CUSTOMER_RANKING_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.CUSTOMER_RANKING_DOES_NOT_EXIST.getDescription());
    }
}
