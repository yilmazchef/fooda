package be.fooda.backend.product.view.controller;

import be.fooda.backend.product.dao.ProductIndexer;
import be.fooda.backend.product.dao.ProductRepository;
import be.fooda.backend.product.model.dto.CreateProductRequest;
import be.fooda.backend.product.model.dto.ProductResponse;
import be.fooda.backend.product.model.dto.UpdateProductRequest;
import be.fooda.backend.product.model.http.HttpEndpoints;
import be.fooda.backend.product.model.http.HttpFailureMessages;
import be.fooda.backend.product.model.http.HttpSuccessMessages;
import be.fooda.backend.product.service.mapper.ProductMapper;
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

import static be.fooda.backend.product.model.http.HttpEndpoints.PRODUCTS_PUT_SINGLE_TEXT;

// LOMBOK
@RequiredArgsConstructor
// SPRING
@RestController
@RequestMapping("/api/v2/products") // https://www.fooda.be/api/v2/products
public class ProductController {

    // INJECT_FLOW_BEAN -> must be private and final 
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductIndexer productIndexer;

    // CREATE_NEW_PRODUCT
    @Transactional
    @PostMapping(HttpEndpoints.PRODUCTS_POST_MANY_TEXT)
    public ResponseEntity<List<ProductResponse>> createMany(@RequestBody @Valid @NotNull List<CreateProductRequest> requestList) {

        final var responses = new LinkedList<ProductResponse>();

        for (CreateProductRequest request : requestList) {
            // IF_NOT_EXISTS
            if (!productRepository.existsByTitleAndStoreId(request.getTitle(), request.getStoreId())) {
                responses.add(
                        productMapper.toResponse(
                                productRepository.save(
                                        productMapper.toEntity(request)))
                );
            }
        }

        return responses.isEmpty()
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList())
                : ResponseEntity.status(HttpStatus.CREATED).body(responses);
    }

    // CREATE_NEW_PRODUCT
    @Transactional
    @PostMapping(HttpEndpoints.PRODUCTS_POST_SINGLE_TEXT)
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid @NotNull CreateProductRequest request) {

        if (productRepository.existsByTitleAndStoreId(request.getTitle(), request.getStoreId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMessages.PRODUCT_ALREADY_EXIST.getDescription());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productMapper.toResponse(
                        productRepository.save(
                                productMapper.toEntity(request))));
    }

    // UPDATE_SINGLE_PRODUCT
    @Transactional
    @PatchMapping(PRODUCTS_PUT_SINGLE_TEXT)
    public ResponseEntity<ProductResponse> updateById(@PathVariable("productId") @Positive @NotNull Long productId, @RequestBody @NotNull UpdateProductRequest request) {

        // FLOW_AND_RETURN
        return productRepository
                .findById(productId)
                .map(entity -> productMapper.toEntity(request, entity))
                .map(entity -> productRepository.save(entity))
                .map(entity -> productMapper.toResponse(entity))
                .map(response -> ResponseEntity.status(HttpStatus.ACCEPTED).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.PRODUCT_NOT_FOUND.getDescription());
                });
    }

    // DELETE_BY_ID
    @Transactional
    @DeleteMapping(HttpEndpoints.PRODUCTS_DELETE_BY_ID_MAKE_PASSIVE)
    public ResponseEntity<String> deleteByIdMakePassive(@PathVariable("productId") @NotNull Long productId) {

        return productRepository
                .findById(productId)
                .map(entity -> productRepository.makePassive(entity.getId()))
                .map(deleteCount -> deleteCount > 0
                        ? ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(HttpSuccessMessages.PRODUCT_MADE_PASSIVE.getDescription())
                        : ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(HttpFailureMessages.FAILED_TO_MAKE_PRODUCT_PASSIVE.getDescription())
                )
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.FAILED_TO_MAKE_PRODUCT_PASSIVE.getDescription());
                });
    }

    // DELETE_BY_ID_PERMANENTLY
    @Transactional
    @DeleteMapping(HttpEndpoints.PRODUCTS_DELETE_BY_ID_PERMANENTLY)
    public ResponseEntity<String> deleteByIdPermanently(@PathVariable("productId") @NotNull Long productId) {

        return productRepository
                .findById(productId)
                .map(entity -> {
                    productRepository.deleteById(productId);
                    return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .body(HttpSuccessMessages.PRODUCT_DELETED.getDescription());
                })
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.PRODUCT_NOT_FOUND.getDescription());
                });
    }

    // GET_ALL
    @Transactional
    @GetMapping(HttpEndpoints.PRODUCTS_FIND_ALL_TEXT)
    public ResponseEntity<List<ProductResponse>> findAll(
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(productRepository
                        .findAllByIsActive(true, PageRequest.of(pageNo - 1, pageSize))
                        .map(entity -> productMapper.toResponse(entity))
                        .map(productResponse -> productResponse.withDefaultImage(productResponse.getDefaultImage().withUrl("https://picsum.photos/1920/1080")))
                        .toList());
    }

    // GET_BY_ID
    @Transactional
    @GetMapping(HttpEndpoints.PRODUCTS_FIND_BY_ID_TEXT)
    public ResponseEntity<ProductResponse> findById(@PathVariable("productId") @NotNull Long productId) {

        return productRepository
                .findById(productId)
                .map(entity -> productMapper.toResponse(entity))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.PRODUCT_NOT_FOUND.getDescription());
                });
    }

    // SEARCH(KEYWORD)
    @Transactional
    @GetMapping(HttpEndpoints.PRODUCTS_SEARCH_TEXT)
    public ResponseEntity<List<ProductResponse>> search(
            @PathVariable("keyword") @NotNull String keyword,
            @RequestParam(
                    value = HttpEndpoints.PAGE_NUMBER_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(
                    value = HttpEndpoints.PAGE_SIZE_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(productIndexer
                        .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                        .map(entity -> productMapper.toResponse(entity))
                        .map(productResponse -> productResponse.withDefaultImage(productResponse.getDefaultImage().withUrl("https://picsum.photos/1920/1080")))
                        .toList());
    }

    // EXISTS_BY_ID
    @Transactional
    @GetMapping(HttpEndpoints.PRODUCTS_FIND_EXISTS_BY_ID_TEXT)
    public ResponseEntity<String> existsById(@PathVariable("productId") @NotNull Long productId) {

        return productRepository.existsById(productId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.PRODUCT_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.PRODUCT_DOES_NOT_EXIST.getDescription());
    }

    // EXISTS_BY_UNIQUE_FIELDS
    @Transactional
    @GetMapping(HttpEndpoints.PRODUCT_EXISTS_BY_UNIQUE_FIELDS)
    public ResponseEntity<String> existsByUniqueFields(@RequestParam("title") String title, @RequestParam("storeId") Long storeId) {

        return productRepository.existsByTitleAndStoreId(title, storeId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.PRODUCT_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.PRODUCT_DOES_NOT_EXIST.getDescription());
    }


}
