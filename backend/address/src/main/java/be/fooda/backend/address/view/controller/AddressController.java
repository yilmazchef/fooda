package be.fooda.backend.address.view.controller;

import be.fooda.backend.address.dao.AddressIndexer;
import be.fooda.backend.address.dao.AddressRepository;
import be.fooda.backend.address.model.dto.AddressResponse;
import be.fooda.backend.address.model.dto.CreateAddressRequest;
import be.fooda.backend.address.model.dto.UpdateAddressRequest;
import be.fooda.backend.address.model.http.HttpEndpoints;
import be.fooda.backend.address.model.http.HttpFailureMessages;
import be.fooda.backend.address.model.http.HttpSuccessMessages;
import be.fooda.backend.address.service.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

import static be.fooda.backend.address.model.http.HttpEndpoints.ADDRESSS_PUT_SINGLE_TEXT;

// LOMBOK
@RequiredArgsConstructor
// SPRING
@RestController
@RequestMapping("/api/v2/addresss") // https://www.fooda.be/api/v1/addresss
public class AddressController {

    // INJECT_FLOW_BEAN -> must be private and final 
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final AddressIndexer addressIndexer;
    
    // CREATE_NEW_ADDRESS
    @Transactional
    @PostMapping(HttpEndpoints.ADDRESSS_POST_SINGLE_TEXT)
    public ResponseEntity<String> create(@RequestBody @Valid @NotNull CreateAddressRequest request) {

        if(addressRepository.existsByTitleAndUserId(request.getTitle(), request.getUserId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMessages.ADDRESS_ALREADY_EXIST.getDescription());
        }
      
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("saved_id", String.valueOf(
                        addressRepository.save(addressMapper.toEntity(request)).getId())
                )
                .body(HttpSuccessMessages.ADDRESS_CREATED.getDescription());
    }

    // UPDATE_SINGLE_ADDRESS
    @Transactional
    @PutMapping(ADDRESSS_PUT_SINGLE_TEXT)
    public ResponseEntity<String> updateById(@PathVariable("addressId") Long addressId, @RequestBody @Valid @NotNull UpdateAddressRequest request) {

        // FLOW_AND_RETURN
        return addressRepository
                .findById(addressId)
                .map(entity -> addressMapper.toEntity(request, entity))
                .map(entity -> addressRepository.save(entity))
                .map(entity -> ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .header("updated_id", String.valueOf(entity.getId()))
                        .body(HttpSuccessMessages.ADDRESS_UPDATED.getDescription()))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.ADDRESS_NOT_FOUND.getDescription());
                });
    }

    // DELETE_BY_ID
    @Transactional
    @DeleteMapping(HttpEndpoints.ADDRESSS_DELETE_BY_ID)
    public ResponseEntity<String> deleteById(@PathVariable("addressId") @NotNull Long addressId) {

        return addressRepository
                .findById(addressId)
                .map(entity -> addressRepository.makePassive(entity.getId()))
                .map(deleteCount -> deleteCount > 0
                        ? ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(HttpSuccessMessages.ADDRESS_MADE_PASSIVE.getDescription())
                        : ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(HttpFailureMessages.FAILED_TO_MAKE_ADDRESS_PASSIVE.getDescription())
                )
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.FAILED_TO_MAKE_ADDRESS_PASSIVE.getDescription());
                });
    }

    // DELETE_BY_ID_PERMANENTLY
    @Transactional
    @DeleteMapping(HttpEndpoints.ADDRESSS_DELETE_BY_ID_PERMANENTLY)
    public ResponseEntity<String> deleteByIdPermanently(@PathVariable("addressId") @NotNull Long addressId) {

        return addressRepository
                .findById(addressId)
                .map(entity -> {
                    addressRepository.deleteById(addressId);
                    return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .body(HttpSuccessMessages.ADDRESS_DELETED.getDescription());
                })
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.ADDRESS_NOT_FOUND.getDescription());
                });
    }

    // @PatchMapping // UPDATE ADDRESS(S) BUT NOT ALL THE FIELDS

    // GET_ALL
    @Transactional
    @GetMapping(HttpEndpoints.ADDRESSS_FIND_ALL_TEXT)
    public ResponseEntity<List<AddressResponse>> findAll(
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        addressRepository
                                .findAllByIsActive(true, PageRequest.of(pageNo - 1, pageSize))
                                .stream()
                                .map(entity -> addressMapper.toResponse(entity))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // GET_BY_ID
    @Transactional
    @GetMapping(HttpEndpoints.ADDRESSS_FIND_BY_ID_TEXT)
    public ResponseEntity<AddressResponse> findById(@PathVariable("addressId") @NotNull Long addressId) {

        return addressRepository
                .findById(addressId)
                .map(entity -> addressMapper.toResponse(entity))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.ADDRESS_NOT_FOUND.getDescription());
                });
    }

    // SEARCH(KEYWORDS)
    @Transactional
    @GetMapping(HttpEndpoints.ADDRESSS_SEARCH_TEXT)
    public ResponseEntity<List<AddressResponse>> search(
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
                        addressIndexer
                                .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                                .stream()
                                .map(entity -> addressMapper.toResponse(entity))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // EXISTS_BY_ID
    @Transactional
    @GetMapping(HttpEndpoints.ADDRESSS_FIND_EXISTS_BY_ID_TEXT)
    public ResponseEntity<String> existsById(@PathVariable("addressId") @NotNull Long addressId) {

        return addressRepository.existsById(addressId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.ADDRESS_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.ADDRESS_DOES_NOT_EXIST.getDescription());
    }

    // EXISTS_BY_UNIQUE_FIELDS
    @Transactional
    @GetMapping(HttpEndpoints.ADDRESS_EXISTS_BY_UNIQUE_FIELDS)
    public ResponseEntity<String> existsByUniqueFields(@RequestParam("title") String title, @RequestParam("userId") Long userId) {

        return addressRepository.existsByTitleAndUserId(title, userId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMessages.ADDRESS_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMessages.ADDRESS_DOES_NOT_EXIST.getDescription());
    }


}
