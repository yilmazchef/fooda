package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.BasketRepository;
import be.fooda.backend.basket.model.document.BasketDocument;
import be.fooda.backend.basket.model.document.ProductDocument;
import be.fooda.backend.basket.model.dto.BasketResponse;
import be.fooda.backend.basket.model.dto.CreateBasketRequest;
import be.fooda.backend.basket.model.dto.UpdateBasketRequest;
import be.fooda.backend.basket.model.http.HttpEndpoints;
import be.fooda.backend.basket.model.http.HttpFailureMessages;
import be.fooda.backend.basket.model.http.HttpSuccessMessages;
import be.fooda.backend.basket.service.mapper.BasketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v2/basket/")
@RequiredArgsConstructor
public class BasketControllerV2 {

    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;

    // CREATING_NEW_BASKET
    @PostMapping(HttpEndpoints.POST_SINGLE)
    public ResponseEntity<BasketResponse> create(@RequestBody @Valid @NotNull CreateBasketRequest request) {

        if (basketRepository.existsBySessionAndStore_StoreId(request.getSession(), request.getStore().getStoreId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpFailureMessages.BASKET_EXIST_CANNOT_BE_CREATED.getDescription());
        }
        BasketDocument basketDocument = basketMapper.toDocument(request);

        basketDocument.setTotalPrice(
                basketDocument.getProducts().stream()
                        .map(p ->
                                p.getPrice().
                                        multiply(BigDecimal.valueOf(p.getQuantity()))
                                        .multiply(BigDecimal.valueOf(100).subtract(p.getDiscount()))
                                        .divide(BigDecimal.valueOf(100))).
                        reduce(BigDecimal.ZERO, BigDecimal::add)
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(basketMapper.toResponse(
                        basketRepository.save(basketDocument)
                ));
    }

    // UPDATE_SINGLE_BASKET
    @PutMapping(HttpEndpoints.PUT_SINGLE_BY_ID)
    public ResponseEntity<BasketResponse> updateById(@RequestParam("basketId") @NotNull String basketId,
                                                     @RequestBody @NotNull UpdateBasketRequest request) {

        return basketRepository
                .findById(basketId)
                .map(basketDocument -> basketMapper.toDocument(request, basketDocument))
                .map(basketDocument -> {
                    basketDocument.setTotalPrice(
                            basketDocument.getProducts().stream()
                                    .map(p ->
                                            p.getPrice().
                                                    multiply(BigDecimal.valueOf(p.getQuantity()))
                                                    .multiply(BigDecimal.valueOf(100).subtract(p.getDiscount()))
                                                    .divide(BigDecimal.valueOf(100))).
                                    reduce(BigDecimal.ZERO, BigDecimal::add)
                    );
                    return basketDocument;
                })
                .map(basketDocument -> basketRepository.save(basketDocument))
                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                .map(basketResponse -> ResponseEntity.status(HttpStatus.ACCEPTED).body(basketResponse))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMessages.BASKET_DOES_NOT_EXISTS_CANNOT_BE_UPDATED.getDescription());
                });
    }

    /*// UPDATE_SINGLE_BASKET
    @PutMapping(HttpEndpoints.PUT_SINGLE_BY_SESSION)
    public ResponseEntity<BasketResponse> updateBySession(@RequestParam("session") @NotNull String session,
                                                          @RequestBody @NotNull UpdateBasketRequest request) {

        return basketRepository
                .findBySession(session)
                .map(basketDocument -> basketMapper.toDocument(request, basketDocument))
                .map(basketDocument -> {
                    basketDocument.setTotalPrice(
                            basketDocument.getProducts().stream()
                                    .map(p ->
                                            p.getPrice().
                                                    multiply(BigDecimal.valueOf(p.getQuantity()))
                                                    .multiply(BigDecimal.valueOf(100).subtract(p.getDiscount()))
                                                    .divide(BigDecimal.valueOf(100))).
                                    reduce(BigDecimal.ZERO, BigDecimal::add)
                    );
                    return basketDocument;
                })
                .map(basketDocument -> basketRepository.save(basketDocument))
                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                .map(basketResponse -> ResponseEntity.status(HttpStatus.ACCEPTED).body(basketResponse))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMessages.BASKET_DOES_NOT_EXISTS_CANNOT_BE_UPDATED.getDescription());
                });
    }*/

    @PutMapping(HttpEndpoints.PATCH_SINGLE_BY_ID)
    public ResponseEntity<BasketResponse> updateProductQuantity(@RequestParam("basketId") @NotNull String basketId,
                                                                @RequestParam("productId") @NotNull Long productId,
                                                                @RequestParam("quantity") @NotNull Double quantity) {
        return basketRepository
                .findById(basketId)
                .map(basketDocument -> {
                    final var productDocumentList = new LinkedHashSet<ProductDocument>();
                    for (ProductDocument productDocument : basketDocument.getProducts()) {
                        if (Objects.equals(productDocument.getProductId(), productId) && productDocument.getQuantity() + quantity >= 0) {
                            productDocument.setQuantity(productDocument.getQuantity() + quantity);
                        }
                        productDocumentList.add(productDocument);
                    }
                    basketDocument.setProducts(productDocumentList);
                    return basketDocument;
                })
                .map(basketDocument -> {
                    basketDocument.setTotalPrice(
                            basketDocument.getProducts().stream()
                                    .map(p ->
                                            p.getPrice().
                                                    multiply(BigDecimal.valueOf(p.getQuantity()))
                                                    .multiply(BigDecimal.valueOf(100).subtract(p.getDiscount()))
                                                    .divide(BigDecimal.valueOf(100))).
                                    reduce(BigDecimal.ZERO, BigDecimal::add)
                    );
                    return basketDocument;
                })
                .map(basketDocument -> basketRepository.save(basketDocument))
                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                .map(basketResponse -> ResponseEntity.status(HttpStatus.ACCEPTED).body(basketResponse))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpFailureMessages.BASKET_DOES_NOT_EXISTS_CANNOT_BE_UPDATED.getDescription());
                });
    }

    // MAKE_PASSIVE
    @DeleteMapping(HttpEndpoints.DELETE_BY_ID)
    public ResponseEntity<BasketResponse> deleteByIdMakePassive(@RequestParam("basketId") @NotNull String basketId) {

        return basketRepository
                .findById(basketId)
                .map(basketDocument -> {
                    basketDocument.setActive(false);
                    return basketRepository.save(basketDocument);
                })
                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                .map(basketResponse -> ResponseEntity.status(HttpStatus.ACCEPTED).body(basketResponse))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.ACCEPTED, HttpFailureMessages.BASKET_DOES_NOT_EXISTS_CANNOT_BE_DELETED.getDescription());
                });
    }

    // DELETE_BY_ID
    @DeleteMapping(HttpEndpoints.DELETE_BY_ID_PERMANENTLY)
    public ResponseEntity<String> deleteByIdPermanently(@RequestParam("basketId") @NotNull String basketId) {

        return basketRepository
                .findById(basketId)
                .map(entity -> {
                    basketRepository.deleteById(basketId);
                    return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .body(HttpSuccessMessages.BASKET_DELETED.getDescription());
                })
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.BASKET_NOT_FOUND.getDescription());
                });
    }

    @GetMapping(HttpEndpoints.GET_ALL_BY_SESSION)
    public ResponseEntity<List<BasketResponse>> findAllBySession(@RequestParam("session") @NotNull String session) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        basketRepository
                                .findBySession(session)
                                .stream()
                                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // GET_ALL
    @GetMapping(HttpEndpoints.GET_ALL)
    public ResponseEntity<?> findAll(@RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
                                     @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        basketRepository
                                .findAll(PageRequest.of(pageNo - 1, pageSize))
                                .stream()
                                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // GET_ALL_BY_CUSTOMER_ID
    @GetMapping(HttpEndpoints.GET_ALL_BY_CUSTOMER)
    public ResponseEntity<?> findAllByCustomer(@RequestParam("customerId") Long customerId,
                                             @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
                                             @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        basketRepository
                                .findAllByCustomer_CustomerId(customerId, PageRequest.of(pageNo - 1, pageSize))
                                .stream()
                                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // GET_ALL_BY_CUSTOMER_ID
    @GetMapping(HttpEndpoints.GET_ALL_BY_STORE)
    public ResponseEntity<?> findAllByStore(@RequestParam("storeId") Long storeId,
                                            @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
                                            @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        basketRepository
                                .findAllByStore_StoreId(storeId, PageRequest.of(pageNo - 1, pageSize))
                                .stream()
                                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // GET_ALL_BY_CUSTOMER_ID
    @GetMapping(HttpEndpoints.GET_ALL_BY_CUSTOMER_AND_STORE)
    public ResponseEntity<?> findAllByCustomerAndStore(@RequestParam("customerId") Long customerId, @RequestParam("storeId") Long storeId,
                                                       @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
                                                       @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        basketRepository
                                .findAllByCustomer_CustomerIdAndStore_StoreId(customerId, storeId, PageRequest.of(pageNo - 1, pageSize))
                                .stream()
                                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // GET_ALL_BY_CUSTOMER_ID
    @GetMapping(HttpEndpoints.GET_BY_SESSION_AND_STORE)
    public ResponseEntity<?> findBySessionAndStore(@RequestParam("session") String session, @RequestParam("storeId") Long storeId,
                                                   @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
                                                   @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT, required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        final var basket = basketRepository.findBySessionAndStore_StoreId(session, storeId);
        if(Objects.isNull(basket)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.BASKET_NOT_FOUND.getDescription());
        }

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(basket.map(basketDocument -> basketMapper.toResponse(basketDocument)));

       /* return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        basketRepository
                                .findBySessionAndStore_StoreId(session, storeId)
                                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                                .orElseThrow(() -> {
                                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.BASKET_NOT_FOUND.getDescription());
                                }));*/
    }

    // GET_BY_ID
    @GetMapping(HttpEndpoints.GET_BY_ID)
    public ResponseEntity<?> findById(@RequestParam("basketId") @NotNull String basketId) {

        return basketRepository
                .findById(new String(basketId))
                .map(basketDocument -> basketMapper.toResponse(basketDocument))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.BASKET_NOT_FOUND.getDescription());
                });
    }

    // EXISTS_BY_UNIQUE_FIELDS
    @GetMapping(HttpEndpoints.GET_EXISTS_BY_UNIQUE_FIELDS)
    public ResponseEntity<String> existsByUniqueFields(@RequestParam("session") @NotNull String session, @RequestParam("storeId") @NotNull Long storeId) {

        return basketRepository.existsBySessionAndStore_StoreId(session, storeId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.BASKET_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.BASKET_DOES_NOT_EXIST.getDescription());
    }

    // EXISTS_BY_ID
    @GetMapping(HttpEndpoints.GET_EXISTS_BY_ID)
    public ResponseEntity<String> existsById(@RequestParam("basketId") @NotNull String basketId) {

        return basketRepository.existsById(new String(basketId))
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.BASKET_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.BASKET_DOES_NOT_EXIST.getDescription());
    }
}
