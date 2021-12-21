package be.fooda.backend.courier.view.controller;

import be.fooda.backend.courier.dao.CourierIndexer;
import be.fooda.backend.courier.dao.CourierRepository;
import be.fooda.backend.courier.model.dto.CreateCourierRequest;
import be.fooda.backend.courier.model.dto.CourierResponse;
import be.fooda.backend.courier.model.dto.UpdateCourierRequest;
import be.fooda.backend.courier.model.http.HttpEndpoints;
import be.fooda.backend.courier.model.http.HttpFailureMessages;
import be.fooda.backend.courier.model.http.HttpSuccessMessages;
import be.fooda.backend.courier.service.mapper.CourierMapper;
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
@RequestMapping("api/v2/couriers")
public class CourierController {

    private final CourierRepository courierRepository;
    private final CourierIndexer courierIndexer;
    private final CourierMapper courierMapper;

    // CREATING_NEW_COURIER
    @PostMapping(HttpEndpoints.CREATE_A_COURIER)
    @Transactional
    public ResponseEntity<CourierResponse> create(@RequestBody @Valid @NotNull CreateCourierRequest request) {

//        if (courierRepository.existsByUserIdAndFirstNameAndFamilyName(request.getUserId(), request.getFirstName(),
//                request.getFamilyName())) {
//            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMessages.COURIER_ALREADY_EXIST.getDescription());
//        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        courierMapper.toResponse(
                                courierRepository.save(
                                        courierMapper.toEntity(request)))
                );
    }

    @PatchMapping(HttpEndpoints.UPDATE_BY_ID)
    @Transactional
    public ResponseEntity<CourierResponse> updateById(@PathVariable("courierId") @NotNull Long courierId,
                                             @RequestBody @NotNull UpdateCourierRequest request) {

        final var oEntity = courierRepository.findById(courierId);

        // IF(COURIER_NOT_EXIST)
        if (oEntity.isEmpty()) {
            // THROW_EXCEPTION
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.COURIER_DOES_NOT_EXIST.getDescription());
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courierMapper.toResponse(
                        courierRepository.save(
                                courierMapper.toEntity(request, oEntity.get()))));
    }

    @DeleteMapping(HttpEndpoints.DELETE_BY_ID)
    @Transactional
    public ResponseEntity<String> deleteById(@RequestParam @NotNull Long id) {

        // READ_FROM_DB(ID)
        final var oEntity = courierRepository.findById(id);

        if (oEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.COURIER_DOES_NOT_EXIST.getDescription());
        }

        // DELETE_FROM_DB(ID)
        courierRepository.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(HttpSuccessMessages.COURIER_DELETED.getDescription());
    }


    @Transactional
    @GetMapping(HttpEndpoints.GET_ALL_COURIER)
    public ResponseEntity<List<CourierResponse>> findAll(
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(courierRepository
                        .findAll(PageRequest.of(pageNo - 1, pageSize))
                        .map(entity -> courierMapper.toResponse(entity))
                        .toList());
    }

    @Transactional
    @GetMapping(HttpEndpoints.GET_ALL_BY_USER_ID)
    public ResponseEntity<List<CourierResponse>> findAllByUserId(@PathVariable("userId") Long userId) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(courierRepository
                        .findAllByUserId(userId)
                        .stream()
                        .map(entity -> courierMapper.toResponse(entity))
                        .collect(Collectors.toUnmodifiableList()));
    }

    @GetMapping(HttpEndpoints.GET_BY_ID)
    @Transactional
    public ResponseEntity<CourierResponse> findById(@RequestParam @Positive @NotNull Long id,
                                                     @RequestParam(defaultValue = "true", required = false) Boolean isActive) {

        // READ_FROM_DB(ID)
        final var oEntity = courierRepository.findById(id);

        if (oEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMessages.COURIER_DOES_NOT_EXIST.getDescription());
        }

        // MAP_ENTITY_TO_RESPONSE
        final var response = courierMapper.toResponse(oEntity.get());

        // RETURN SUCCESS
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping(HttpEndpoints.EXISTS_BY_ID)
    @Transactional
    public ResponseEntity<String> existsById(@RequestParam @PositiveOrZero @NotNull Long id) {

        if (!courierRepository.existsById(id))
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(HttpFailureMessages.COURIER_DOES_NOT_EXIST.getDescription());

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(HttpSuccessMessages.COURIER_EXISTS.getDescription());
    }

    @GetMapping(HttpEndpoints.EXISTS_BY_UNIQUE_FIELDS)
    @Transactional
    public ResponseEntity<String> existByUniqueFields(@RequestParam @PositiveOrZero @NotNull Long userId,
                                                      String firstName, String familyName) {

        final var exists = courierRepository.existsByUserIdAndFirstNameAndFamilyName(userId, firstName, familyName);

        if (!exists) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(HttpFailureMessages.COURIER_DOES_NOT_EXIST.getDescription());
        } else {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(HttpSuccessMessages.COURIER_EXISTS.getDescription());
        }
    }

    // SEARCH(KEYWORDS)
    @Transactional
    @GetMapping(HttpEndpoints.COURIER_SEARCH_TEXT)
    public ResponseEntity<List<CourierResponse>> search(
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
                        courierIndexer
                                .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                                .stream()
                                .map(entity -> courierMapper.toResponse(entity))
                                .collect(Collectors.toUnmodifiableList())
                );
    }
}
