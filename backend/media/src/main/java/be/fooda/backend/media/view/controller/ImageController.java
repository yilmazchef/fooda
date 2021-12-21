package be.fooda.backend.media.view.controller;

import be.fooda.backend.media.dao.ImageIndexer;
import be.fooda.backend.media.dao.ImageRepository;
import be.fooda.backend.media.model.dto.CreateImageRequest;
import be.fooda.backend.media.model.dto.ImageResponse;
import be.fooda.backend.media.model.dto.MediaExistenceRequest;
import be.fooda.backend.media.model.dto.UpdateImageRequest;
import be.fooda.backend.media.model.http.HttpEndpoints;
import be.fooda.backend.media.model.http.HttpFailureMassages;
import be.fooda.backend.media.model.http.HttpSuccessMassages;
import be.fooda.backend.media.service.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.rowset.serial.SerialBlob;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Lombok
@RequiredArgsConstructor
// Spring
@RestController
@RequestMapping("/api/v1/media/images/") // https://www.fooda.be/api/v1/media/images
public class ImageController {

    // INJECT_FLOW_BEANS
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;
    private final ImageIndexer imageIndexer;

    /* Return the image from the database using ResponseEntity */
    @GetMapping("find/one/stream/{id}")
    public ResponseEntity<byte[]> findImageStreamById(@PathVariable("id") Long id) {

        return imageRepository
                .findById(id)
                .map(entity -> {
                    try {
                        return entity.getDataAsByte().getBytes(1, (int) entity.getDataAsByte().length());
                    } catch (SQLException sqlException) {
                        throw new ResponseStatusException(HttpStatus.CONFLICT, sqlException.getMessage());
                    }
                })
                .map(imageBytes -> ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG).body(imageBytes))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMassages.IMAGE_BY_ID_NOT_FOUND.getDescription());
                });
    }

    /* Return the image from the classpath location using ResponseEntity */
    @GetMapping(value = "find/one/stream/path/")
    public ResponseEntity<byte[]> findImageByteByPath() {

        // BUSINESS_FLOW
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .contentType(MediaType.IMAGE_JPEG).body(
                            StreamUtils.copyToByteArray(new ClassPathResource("images/products/product1.jpg").getInputStream())
                    );
        } catch (IOException ioException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpFailureMassages.IMAGE_NOT_FOUND.getDescription());
        }
    }

    // CREATING_NEW_MEDIA
    // Spring
    @PostMapping(
            value = HttpEndpoints.POST_SINGLE,
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE }
        )
    // JavaX
    @Transactional
    public ResponseEntity<String> create(
            @RequestBody @Valid @NotNull CreateImageRequest request,
            @RequestPart("image") MultipartFile image) {

        try (final var scanner = new Scanner(image.getInputStream())) {
            Blob blob = null;
            while (scanner.hasNext()) {
                final var myArray = scanner.nextLine().getBytes();
                blob = new SerialBlob(myArray);
            }
            request.setDataAsByte(blob);

        } catch (IOException | SQLException blobException) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, HttpFailureMassages.UNKNOWN_FAILURE.getDescription());
        }

        // CREATE_FLOW
        return imageRepository
                .findByUserIdAndRelatedId(request.getUserId(), request.getUserId())
                .map(entity -> imageMapper.toEntity(request))
                .map(entity -> imageRepository.save(entity))
                .map(savedEntity -> imageMapper.toResponse(savedEntity))
                .map(response -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .header("savedId", String.valueOf(response.getImageId()))
                        .body(HttpSuccessMassages.MEDIA_CREATED.getDescription()))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpFailureMassages.MEDIA_ALREADY_EXIST.getDescription());
                });

    }

    // UPDATE_SINGLE_MEDIA
    // Spring
    @PutMapping(HttpEndpoints.PUT_SINGLE)
    // JavaX
    @Transactional
    public ResponseEntity<String> update(@PathVariable @NotNull @Positive Long id,
                                         @RequestBody @Valid @NotNull UpdateImageRequest request) {

        // UPDATE_FLOW
        return imageRepository
                .findById(id)
                .map(entity -> imageMapper.toEntity(request, entity))
                .map(entity -> imageRepository.save(entity))
                .map(updatedEntity -> imageMapper.toResponse(updatedEntity))
                .map(response -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(HttpSuccessMassages.MEDIA_UPDATED.getDescription()))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpFailureMassages.MEDIA_NOT_FOUND.getDescription());
                });
    }

    // DELETE_BY_ID
    // Spring
    @DeleteMapping(HttpEndpoints.DELETE_BY_ID)
    // JavaX
    @Transactional
    public ResponseEntity<String> deleteById(@PathVariable @NotNull Long id) {

        // DELETE_FLOW
        return imageRepository
                .findById(id)
                .map(entity -> imageRepository.makePassive(id) > 0)
                .map(isMadePassive -> isMadePassive ?
                        ResponseEntity
                                .status(HttpStatus.ACCEPTED)
                                .body(HttpSuccessMassages.MEDIA_DELETED.getDescription()) :
                        ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .body(HttpFailureMassages.MEDIA_COULD_NOT_BE_DELETED.getDescription()))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpFailureMassages.MEDIA_DOES_NOT_EXIST.getDescription());
                });
    }

    // DELETE_BY_ID_PERMANENTLY
    // Spring
    @DeleteMapping(HttpEndpoints.DELETE_BY_ID_PERMANENTLY)
    // JavaX
    @Transactional
    public ResponseEntity<String> deleteByIdPermanently(@PathVariable @NotNull Long id) {

        // DELETE_FLOW
        return imageRepository
                .findById(id)
                .map(entity -> {
                    imageRepository.deleteById(id);
                    return imageRepository.existsById(id);
                })
                .map(isDeleted -> isDeleted ?
                        ResponseEntity
                                .status(HttpStatus.ACCEPTED)
                                .body(HttpSuccessMassages.MEDIA_DELETED.getDescription()) :
                        ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .body(HttpFailureMassages.MEDIA_COULD_NOT_BE_DELETED.getDescription()))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpFailureMassages.MEDIA_DOES_NOT_EXIST.getDescription());
                });
    }

    // @PatchMapping // UPDATE MEDIA(S) BUT NOT ALL THE FIELDS

    // GET_ALL
    // Spring
    @GetMapping(HttpEndpoints.GET_ALL)
    // JavaX
    @Transactional
    public ResponseEntity<List<ImageResponse>> findAll(
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER, required = false) @NotNull Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE, required = false) @NotNull Integer pageSize) {

        // BUSINESS_FLOW
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(imageRepository
                        .findAll(PageRequest.of(pageNo - 1, pageSize))
                        .stream()
                        .map(entity -> imageMapper.toResponse(entity))
                        .collect(Collectors.toUnmodifiableList())
                );
    }

    // FIND_BY_ID
    @GetMapping(HttpEndpoints.FIND_BY_ID)
    public ResponseEntity<ImageResponse> findById(@PathVariable Long id) {

        // BUSINESS_FLOW
        return imageRepository
                .findById(id)
                .map(entity -> imageMapper.toResponse(entity))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMassages.MEDIA_DOES_NOT_EXIST.getDescription());
                });
    }

    // SEARCH(KEYWORDS)
    // Spring
    @GetMapping(HttpEndpoints.GET_SEARCH)
    // JavaX
    @Transactional
    public ResponseEntity<List<ImageResponse>> search(
            @RequestParam String keyword,
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER, required = false) @NotNull Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE, required = false) @NotNull Integer pageSize) {

        // BUSINESS_FLOW
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(imageIndexer
                        .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                        .stream()
                        .map(entity -> imageMapper.toResponse(entity))
                        .collect(Collectors.toUnmodifiableList())
                );
    }

    // EXISTS_BY_ID
    // Spring
    @GetMapping(HttpEndpoints.GET_EXISTS_BY_ID)
    // JavaX
    @Transactional
    public ResponseEntity<String> existsById(@PathVariable Long id) {

        // START_SELECT_FLOW
        return imageRepository.existsByIdAndIsActive(id, true)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMassages.MEDIA_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMassages.MEDIA_DOES_NOT_EXIST.getDescription());
    }

    // EXISTS_BY_UNIQUE_FIELDS
    // Spring
    @GetMapping(HttpEndpoints.GET_EXISTS_BY_UNIQUE_FIELDS)
    // JavaX
    @Transactional
    public ResponseEntity<String> existsByUniqueFields(@RequestBody @Valid @NotNull MediaExistenceRequest request) {

        return imageRepository.existsByUserIdAndRelatedId(request.getUserId(), request.getRelatedId())
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMassages.MEDIA_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMassages.MEDIA_DOES_NOT_EXIST.getDescription());
    }

}