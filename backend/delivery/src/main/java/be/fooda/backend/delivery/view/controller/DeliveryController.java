package be.fooda.backend.delivery.view.controller;


import be.fooda.backend.delivery.dao.DeliveryIndexer;
import be.fooda.backend.delivery.dao.DeliveryRepository;
import be.fooda.backend.delivery.model.dto.CreateDeliveryRequest;
import be.fooda.backend.delivery.model.dto.DeliveryResponse;
import be.fooda.backend.delivery.model.dto.UpdateDeliveryRequest;
import be.fooda.backend.delivery.model.http.HttpFailureMessages;
import be.fooda.backend.delivery.model.http.HttpSuccessMessages;
import be.fooda.backend.delivery.service.mapper.DeliveryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

import static be.fooda.backend.delivery.model.http.HttpEndpoints.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v2/delivery")
public class DeliveryController {


    // INJECT_FLOW_BEAN
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;
    private final DeliveryIndexer deliveryIndexer;

    // RESPONSE_ENTITY = STATUS, HEADERS, BODY

    // CREATING_NEW_DELIVERY
    @PostMapping(POST_SINGLE)
    @Transactional
    public ResponseEntity<DeliveryResponse> create(@RequestBody @Valid @NotNull CreateDeliveryRequest request) {

        if (deliveryRepository.existsByOrderIdAndStoreId(request.getOrderId(), request.getStoreId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMessages.DELIVERY_ALREADY_EXIST.getDescription());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(deliveryMapper.toResponse(
                        deliveryRepository.save(
                                deliveryMapper.toEntity(request)
                        )));
    }

    // UPDATE_SINGLE_DELIVERY
    @PutMapping(PUT_SINGLE)
    @Transactional
    public ResponseEntity update(@PathVariable("deliveryId") Long deliveryId,
                                 @RequestBody @Valid @NotNull UpdateDeliveryRequest request) {

        // FLOW_AND_RETURN
        return deliveryRepository
                .findById(deliveryId)
                .map(entity -> deliveryMapper.toEntity(request, entity))
                .map(entity -> deliveryRepository.save(entity))
                .map(entity-> deliveryMapper.toResponse(entity))
                .map(entity -> ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .header("updated_id", String.valueOf(entity.getId()))
                        .body(entity))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.DELIVERY_NOT_FOUND.getDescription()));

    }

    // DELETE_BY_ID
    @DeleteMapping(DELETE_BY_ID)
    @Transactional
    public ResponseEntity deleteById(@PathVariable("deliveryId") Long deliveryId) {

        return deliveryRepository
                .findById(deliveryId)
                .map(entity -> deliveryRepository.makePassive(entity.getId()))
                .map(deleteCount -> deleteCount > 0
                        ? ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(HttpSuccessMessages.DELIVERY_MADE_PASSIVE.getDescription())
                        : ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(HttpFailureMessages.FAILED_TO_MAKE_DELIVERY_PASSIVE.getDescription())
                )
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.FAILED_TO_MAKE_DELIVERY_PASSIVE.getDescription()));
    }

    // DELETE_BY_ID_PERMANENTLY
    @DeleteMapping(DELETE_BY_ID_PERMANENTLY)
    @Transactional
    public ResponseEntity deleteByIdPermanently(@PathVariable("deliveryId") Long deliveryId) {

        return deliveryRepository
                .findById(deliveryId)
                .map(entity -> {
                    deliveryRepository.deleteById(deliveryId);
                    return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .body(HttpSuccessMessages.DELIVERY_DELETED.getDescription());
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.DELIVERY_NOT_FOUND.getDescription()));
    }


    // GET_ALL
    @GetMapping(GET_ALL)
    @Transactional
    public ResponseEntity findAll(
            @RequestParam(value = PAGE_NUMBER_TEXT, required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(value = PAGE_SIZE, required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        deliveryRepository
                                .findAllByActive(true, PageRequest.of(pageNo - 1, pageSize))
                                .stream()
                                .map(entity -> deliveryMapper.toResponse(entity))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // GET_BY_ID
    @GetMapping(GET_BY_ID)
    @Transactional
    public ResponseEntity findById(@PathVariable("deliveryId") Long deliveryId) {

        return deliveryRepository
                .findById(deliveryId)
                .map(entity -> deliveryMapper.toResponse(entity))
                .map(response -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.DELIVERY_NOT_FOUND.getDescription()));
    }

    // SEARCH(KEYWORDS)
    @GetMapping(GET_SEARCH)
    @Transactional
    public ResponseEntity<List<DeliveryResponse>> search(
            @RequestParam("keyword") @NotNull String keyword,
            @RequestParam(
                    value = PAGE_NUMBER_TEXT,
                    required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(
                    value = PAGE_SIZE_TEXT,
                    required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        // FLOW_AND_RETURN
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(deliveryIndexer
                        .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                        .map(entity -> deliveryMapper.toResponse(entity))
                        .toList()
                );
    }

    // EXISTS_BY_ID
    @GetMapping(GET_EXISTS_BY_ID)
    @Transactional
    public ResponseEntity existsById(@PathVariable("deliveryId") @NotNull Long deliveryId) {

        return deliveryRepository.existsById(deliveryId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.DELIVERY_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.DELIVERY_DOES_NOT_EXIST.getDescription());
    }

    // EXISTS_BY_UNIQUE_FIELDS
    @GetMapping(GET_EXISTS_BY_UNIQUE_FIELDS)
    @Transactional
    public ResponseEntity existsByUniqueFields(@RequestParam("orderId") Long orderId,
                                               @RequestParam("storeId") Long storeId) {

        return deliveryRepository.existsByOrderIdAndStoreId(orderId, storeId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.DELIVERY_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.DELIVERY_DOES_NOT_EXIST.getDescription());
    }
}
