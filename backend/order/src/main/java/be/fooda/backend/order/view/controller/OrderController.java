package be.fooda.backend.order.view.controller;

import be.fooda.backend.order.dao.OrderIndexer;
import be.fooda.backend.order.dao.OrderRepository;
import be.fooda.backend.order.model.dto.CreateOrderRequest;
import be.fooda.backend.order.model.dto.ExistsByUniqueFieldsRequest;
import be.fooda.backend.order.model.dto.OrderResponse;
import be.fooda.backend.order.model.dto.UpdateOrderRequest;
import be.fooda.backend.order.model.http.HttpFailureMessages;
import be.fooda.backend.order.model.http.HttpSuccessMessages;
import be.fooda.backend.order.service.mapper.OrderMapper;
import be.fooda.backend.order.view.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    public static final String CREATE_SINGLE_ORDER = "/create/one";
    public static final String CREATE_MULTIPLE_ORDERS = "/create/all";
    public static final String GET_BY_ID = "/get/one/{orderId}";
    public static final String CLONE_BY_ID = "/create/clone/{orderId}";
    public static final String GET_EXISTS_BY_ID = "/exists/one/{orderId}";
    public static final String GET_EXISTS_BY_UNIQUE_FIELDS = "/exists/unique";
    public static final String GET_ALL_ORDERS = "/get/all";
    public static final String ORDERS_SEARCH_TEXT = "search/{keyword}";
    public static final String UPDATE_SINGLE_ORDER = "/update/one/{orderId}";
    public static final String UPDATE_MULTIPLE_ORDERS = "/update/all";
    public static final String DELETE_BY_ID = "/delete/one/{orderId}";

    // PAGING DEFAULTS
    public static final String PAGE_NUMBER_TEXT = "pageNo";
    public static final String PAGE_SIZE_TEXT = "pageSize";
    public static final String PAGE_NUMBER_DEFAULT_VALUE = "1";
    public static final String PAGE_SIZE_DEFAULT_VALUE = "50";


    // INJECT_FLOW_BEAN, PRODUCT_CLIENT BEAN
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderIndexer orderIndexer;

    // RESPONSE ENTITY = STATUS, HEADER, BODY

    // CREATING NEW ORDER
    @Transactional
    @PostMapping(CREATE_SINGLE_ORDER)
    public ResponseEntity<OrderResponse> create(@RequestBody @Valid @NotNull CreateOrderRequest request) {

        if (orderRepository.existsByStoreIdAndCustomerIdAndDeliveryId(request.getStoreId(),
                request.getCustomerId(), request.getDeliveryId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMessages.ORDER_ALREADY_EXIST.getDescription());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        orderMapper.toResponse(
                                orderRepository.save(
                                        orderMapper.toEntity(request)))
                );
    }

    // FIND_SINGLE_ORDER
    @Transactional
    @GetMapping(GET_BY_ID)
    public ResponseEntity findById(@PathVariable("orderId") @NotNull Long orderId) {

        return orderRepository
                .findById(orderId)
                .map(source -> orderMapper.toResponse(source))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.ORDER_DOES_NOT_EXIST.getDescription());
                });
    }

    // CLONE SINGLE ORDER
    @Transactional
    @GetMapping(CLONE_BY_ID)
    public ResponseEntity cloneById(@PathVariable("orderId") @NotNull Long orderId) {

        return orderRepository
                .findById(orderId)
                .map(entity -> orderMapper.toCloneEntity(entity))
                .map(source -> orderMapper.toResponse(source))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.ORDER_DOES_NOT_EXIST.getDescription());
                });
    }

    @Transactional
    @GetMapping(GET_EXISTS_BY_ID)
    public ResponseEntity existsById(@PathVariable("orderId") @NotNull Long orderId) {

        return orderRepository.existsById(orderId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.ORDER_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.ORDER_DOES_NOT_EXIST.getDescription());

    }

    @Transactional
    @GetMapping(GET_EXISTS_BY_UNIQUE_FIELDS)
    public ResponseEntity existsByUniqueFields(@RequestBody @Valid @NotNull ExistsByUniqueFieldsRequest request) {

        return orderRepository
                .existsByStoreIdAndCustomerIdAndDeliveryId(request.getStoreId(), request.getCustomerId(), request.getDeliveryId())
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.ORDER_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.ORDER_DOES_NOT_EXIST.getDescription());

    }

    @Transactional
    @PutMapping(UPDATE_SINGLE_ORDER)
    public ResponseEntity<OrderResponse> update(@PathVariable("orderId") Long orderId, @RequestBody @NotNull UpdateOrderRequest request) {

        return orderRepository
                .findById(orderId)
                .map(entity -> orderMapper.toEntity(request, entity))
                .map(entity -> orderRepository.save(entity))
                .map(entity -> orderMapper.toResponse(entity))
                .map(response -> ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.NO_ORDERS_FOUND.getDescription());
                });
    }

    @Transactional
    @GetMapping(GET_ALL_ORDERS)
    public ResponseEntity<List<OrderResponse>> findAll(
            @RequestParam(value = PAGE_NUMBER_TEXT,
                    required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(value = PAGE_SIZE_TEXT,
                    required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(
                        orderRepository
                                .findAll(PageRequest.of(pageNo - 1, pageSize))
                                .map(entity -> orderMapper.toResponse(entity))
                                .toList());
    }

    @Transactional
    @GetMapping(ORDERS_SEARCH_TEXT)
    public ResponseEntity<List<OrderResponse>> search(
            @PathVariable("keyword") @NotNull String keyword,
            @RequestParam(value = PAGE_NUMBER_TEXT,
                    required = false, defaultValue = PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(value = PAGE_SIZE_TEXT,
                    required = false, defaultValue = PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(
                        orderIndexer
                                .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                                .map(entity -> orderMapper.toResponse(entity))
                                .toList());
    }

    @Transactional
    @DeleteMapping(DELETE_BY_ID)
    public ResponseEntity<String> deleteById(@PathVariable("orderId") @NotNull Long orderId) {

        return orderRepository.findById(orderId)
                .map(entity -> {
                    orderRepository.deleteById(orderId);

                    return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .body(HttpSuccessMessages.ORDER_DELETED.getDescription());

                })
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.NO_ORDERS_FOUND.getDescription());
                });
    }


    @GetMapping("/api/v1/orders/sandbox")
    public BigDecimal getDefaultPriceFromProductClient(@RequestParam Long productId) {
        return productClient.getDefaultPrice(productId);
    }
}
