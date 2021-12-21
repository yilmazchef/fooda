package be.fooda.backend.payment.view.controller;

import be.fooda.backend.payment.dao.PaymentIndexer;
import be.fooda.backend.payment.dao.PaymentRepository;
import be.fooda.backend.payment.model.dto.CreatePaymentRequest;
import be.fooda.backend.payment.model.dto.PaymentResponse;
import be.fooda.backend.payment.model.dto.UpdatePaymentRequest;
import be.fooda.backend.payment.model.http.HttpEndpoints;
import be.fooda.backend.payment.model.http.HttpFailureMessages;
import be.fooda.backend.payment.model.http.HttpSuccessMessages;
import be.fooda.backend.payment.service.mapper.PaymentMapper;
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
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static be.fooda.backend.payment.model.http.HttpEndpoints.PAYMENTS_PUT_SINGLE_TEXT;

// LOMBOK
@RequiredArgsConstructor
// SPRING
@RestController
@RequestMapping("/api/v2/payments") // https://www.fooda.be/api/v2/payments
public class PaymentController {

    // INJECT_FLOW_BEAN -> must be private and final 
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final PaymentIndexer paymentIndexer;

    // CREATE_NEW_PAYMENT
    @Transactional
    @PostMapping(HttpEndpoints.PAYMENTS_POST_MANY_TEXT)
    public ResponseEntity<List<PaymentResponse>> createMany(@RequestBody @Valid @NotNull List<CreatePaymentRequest> requestList) {

        final var responses = new LinkedList<PaymentResponse>();

        for (CreatePaymentRequest request : requestList) {
            // IF_NOT_EXISTS
            if (!paymentRepository.existsByTitleAndStoreId(request.getTitle(), request.getStoreId())) {
                responses.add(
                        paymentMapper.toResponse(
                                paymentRepository.save(
                                        paymentMapper.toEntity(request)))
                );
            }
        }

        return responses.isEmpty()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList())
                : ResponseEntity.status(HttpStatus.CREATED).body(responses);
    }

    // CREATE_NEW_PAYMENT
    @Transactional
    @PostMapping(HttpEndpoints.PAYMENTS_POST_SINGLE_TEXT)
    public ResponseEntity<PaymentResponse> create(@RequestBody @Valid @NotNull CreatePaymentRequest request) {

        if (paymentRepository.existsByTitleAndStoreId(request.getTitle(), request.getStoreId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMessages.PAYMENT_ALREADY_EXIST.getDescription());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(paymentMapper.toResponse(
                        paymentRepository.save(
                                paymentMapper.toEntity(request))));
    }

    // UPDATE_SINGLE_PAYMENT
    @Transactional
    @PatchMapping(PAYMENTS_PUT_SINGLE_TEXT)
    public ResponseEntity<PaymentResponse> updateById(@PathVariable("paymentId") @Positive @NotNull Long paymentId, @RequestBody @NotNull UpdatePaymentRequest request) {

        // FLOW_AND_RETURN
        return paymentRepository
                .findById(paymentId)
                .map(entity -> paymentMapper.toEntity(request, entity))
                .map(entity -> paymentRepository.save(entity))
                .map(entity -> paymentMapper.toResponse(entity))
                .map(response -> ResponseEntity.status(HttpStatus.ACCEPTED).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.PAYMENT_NOT_FOUND.getDescription());
                });
    }

    // DELETE_BY_ID
    @Transactional
    @DeleteMapping(HttpEndpoints.PAYMENTS_DELETE_BY_ID_MAKE_PASSIVE)
    public ResponseEntity<String> deleteByIdMakePassive(@PathVariable("paymentId") @NotNull Long paymentId) {

        return paymentRepository
                .findById(paymentId)
                .map(entity -> paymentRepository.makePassive(entity.getId()))
                .map(deleteCount -> deleteCount > 0
                        ? ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(HttpSuccessMessages.PAYMENT_MADE_PASSIVE.getDescription())
                        : ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(HttpFailureMessages.FAILED_TO_MAKE_PAYMENT_PASSIVE.getDescription())
                )
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.FAILED_TO_MAKE_PAYMENT_PASSIVE.getDescription());
                });
    }

    // DELETE_BY_ID_PERMANENTLY
    @Transactional
    @DeleteMapping(HttpEndpoints.PAYMENTS_DELETE_BY_ID_PERMANENTLY)
    public ResponseEntity<String> deleteByIdPermanently(@PathVariable("paymentId") @NotNull Long paymentId) {

        return paymentRepository
                .findById(paymentId)
                .map(entity -> {
                    paymentRepository.deleteById(paymentId);
                    return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .body(HttpSuccessMessages.PAYMENT_DELETED.getDescription());
                })
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.PAYMENT_NOT_FOUND.getDescription());
                });
    }

    // GET_ALL
    @Transactional
    @GetMapping(HttpEndpoints.PAYMENTS_FIND_ALL_TEXT)
    public ResponseEntity<List<PaymentResponse>> findAll(
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(paymentRepository
                        .findAllByIsActive(true, PageRequest.of(pageNo - 1, pageSize))
                        .map(entity -> paymentMapper.toResponse(entity))
                        .map(paymentResponse -> paymentResponse.withDefaultImage(paymentResponse.getDefaultImage().withUrl("https://picsum.photos/1920/1080")))
                        .toList());
    }

    // GET_BY_ID
    @Transactional
    @GetMapping(HttpEndpoints.PAYMENTS_FIND_BY_ID_TEXT)
    public ResponseEntity<PaymentResponse> findById(@PathVariable("paymentId") @NotNull Long paymentId) {

        return paymentRepository
                .findById(paymentId)
                .map(entity -> paymentMapper.toResponse(entity))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.PAYMENT_NOT_FOUND.getDescription());
                });
    }

    // SEARCH(KEYWORD)
    @Transactional
    @GetMapping(HttpEndpoints.PAYMENTS_SEARCH_TEXT)
    public ResponseEntity<List<PaymentResponse>> search(
            @PathVariable("keyword") @NotNull String keyword,
            @RequestParam(
                    value = HttpEndpoints.PAGE_NUMBER_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(
                    value = HttpEndpoints.PAGE_SIZE_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(paymentIndexer
                        .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                        .map(entity -> paymentMapper.toResponse(entity))
                        .map(paymentResponse -> paymentResponse.withDefaultImage(paymentResponse.getDefaultImage().withUrl("https://picsum.photos/1920/1080")))
                        .toList());
    }

    // EXISTS_BY_ID
    @Transactional
    @GetMapping(HttpEndpoints.PAYMENTS_FIND_EXISTS_BY_ID_TEXT)
    public ResponseEntity<String> existsById(@PathVariable("paymentId") @NotNull Long paymentId) {

        return paymentRepository.existsById(paymentId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.PAYMENT_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.PAYMENT_DOES_NOT_EXIST.getDescription());
    }

    // EXISTS_BY_UNIQUE_FIELDS
    @Transactional
    @GetMapping(HttpEndpoints.PAYMENT_EXISTS_BY_UNIQUE_FIELDS)
    public ResponseEntity<String> existsByUniqueFields(@RequestParam("title") String title, @RequestParam("storeId") Long storeId) {

        return paymentRepository.existsByTitleAndStoreId(title, storeId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.PAYMENT_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.PAYMENT_DOES_NOT_EXIST.getDescription());
    }


}
