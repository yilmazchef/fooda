package be.fooda.backend.customer.view.controller;

import be.fooda.backend.customer.dao.CustomerIndexer;
import be.fooda.backend.customer.dao.CustomerRepository;
import be.fooda.backend.customer.model.dto.CreateCustomerRequest;
import be.fooda.backend.customer.model.dto.CustomerResponse;
import be.fooda.backend.customer.model.dto.UpdateCustomerRequest;
import be.fooda.backend.customer.model.http.HttpEndpoints;
import be.fooda.backend.customer.model.http.HttpFailureMessages;
import be.fooda.backend.customer.model.http.HttpSuccessMessages;
import be.fooda.backend.customer.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v2/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerIndexer customerIndexer;
    private final CustomerMapper customerMapper;

    // CREATING_NEW_CUSTOMER
    @PostMapping(HttpEndpoints.CREATE_A_CUSTOMER)
    @Transactional
    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid @NotNull CreateCustomerRequest request) {

//        if (customerRepository.existsByUserIdAndFirstNameAndFamilyName(request.getUserId(), request.getFirstName(),
//                request.getFamilyName())) {
//            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMessages.CUSTOMER_ALREADY_EXIST.getDescription());
//        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        customerMapper.toResponse(
                                customerRepository.save(
                                        customerMapper.toEntity(request)))
                );
    }

    @PatchMapping(HttpEndpoints.UPDATE_BY_ID)
    @Transactional
    public ResponseEntity<CustomerResponse> updateById(@PathVariable("customerId") @NotNull Long customerId,
                                             @RequestBody @NotNull UpdateCustomerRequest request) {

        final var oEntity = customerRepository.findById(customerId);

        // IF(CUSTOMER_NOT_EXIST)
        if (oEntity.isEmpty()) {
            // THROW_EXCEPTION
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.CUSTOMER_DOES_NOT_EXIST.getDescription());
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerMapper.toResponse(
                        customerRepository.save(
                                customerMapper.toEntity(request, oEntity.get()))));
    }

    @DeleteMapping(HttpEndpoints.DELETE_BY_ID)
    @Transactional
    public ResponseEntity<String> deleteById(@RequestParam @NotNull Long id) {

        // READ_FROM_DB(ID)
        final var oEntity = customerRepository.findById(id);

        if (oEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.CUSTOMER_DOES_NOT_EXIST.getDescription());
        }

        // DELETE_FROM_DB(ID)
        customerRepository.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(HttpSuccessMessages.CUSTOMER_DELETED.getDescription());
    }


    @Transactional
    @GetMapping(HttpEndpoints.GET_ALL_CUSTOMER)
    public ResponseEntity<List<CustomerResponse>> findAll(
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(customerRepository
                        .findAllByIsActive(true, PageRequest.of(pageNo - 1, pageSize))
                        .map(entity -> customerMapper.toResponse(entity))
                        .toList());
    }

    @Transactional
    @GetMapping(HttpEndpoints.GET_ALL_BY_USER_ID)
    public ResponseEntity<List<CustomerResponse>> findAllByUserId(@PathVariable("userId") Long userId) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(customerRepository
                        .findAllByUserId(userId)
                        .stream()
                        .map(entity -> customerMapper.toResponse(entity))
                        .collect(Collectors.toUnmodifiableList()));
    }

    @GetMapping(HttpEndpoints.GET_BY_ID)
    @Transactional
    public ResponseEntity<CustomerResponse> findById(@RequestParam @Positive @NotNull Long id,
                                                     @RequestParam(defaultValue = "true", required = false) Boolean isActive) {

        // READ_FROM_DB(ID)
        final var oEntity = customerRepository.findById(id);

        if (oEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.CUSTOMER_DOES_NOT_EXIST.getDescription());
        }

        // MAP_ENTITY_TO_RESPONSE
        final var response = customerMapper.toResponse(oEntity.get());

        // RETURN SUCCESS
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping(HttpEndpoints.EXISTS_BY_ID)
    @Transactional
    public ResponseEntity<String> existsById(@RequestParam @PositiveOrZero @NotNull Long id) {

        if (!customerRepository.existsById(id))
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(HttpFailureMessages.CUSTOMER_DOES_NOT_EXIST.getDescription());

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(HttpSuccessMessages.CUSTOMER_EXISTS.getDescription());
    }

    @GetMapping(HttpEndpoints.EXISTS_BY_UNIQUE_FIELDS)
    @Transactional
    public ResponseEntity<String> existByUniqueFields(@RequestParam @PositiveOrZero @NotNull Long userId,
                                                      String firstName, String familyName) {

        final var exists = customerRepository.existsByUserIdAndFirstNameAndFamilyName(userId, firstName, familyName);

        if (!exists) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(HttpFailureMessages.CUSTOMER_DOES_NOT_EXIST.getDescription());
        } else {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(HttpSuccessMessages.CUSTOMER_EXISTS.getDescription());
        }
    }

    // SEARCH(KEYWORDS)
    @Transactional
    @GetMapping(HttpEndpoints.CUSTOMER_SEARCH_TEXT)
    public ResponseEntity<List<CustomerResponse>> search(
            @PathVariable("keyword") @NotNull String keyword,
            @RequestParam(
                    value = HttpEndpoints.PAGE_NUMBER_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(
                    value = HttpEndpoints.PAGE_SIZE_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        // FLOW_AND_RETURN
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        customerIndexer
                                .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                                .stream()
                                .map(entity -> customerMapper.toResponse(entity))
                                .collect(Collectors.toUnmodifiableList())
                );
    }
}
