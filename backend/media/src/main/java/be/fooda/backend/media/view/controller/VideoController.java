package be.fooda.backend.media.view.controller;

import be.fooda.backend.media.dao.VideoIndexer;
import be.fooda.backend.media.dao.VideoRepository;
import be.fooda.backend.media.model.dto.CreateVideoRequest;
import be.fooda.backend.media.model.dto.MediaExistenceRequest;
import be.fooda.backend.media.model.dto.UpdateVideoRequest;
import be.fooda.backend.media.model.dto.VideoResponse;
import be.fooda.backend.media.model.http.HttpEndpoints;
import be.fooda.backend.media.model.http.HttpFailureMassages;
import be.fooda.backend.media.model.http.HttpSuccessMassages;
import be.fooda.backend.media.service.mapper.VideoMapper;
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
import java.util.List;
import java.util.stream.Collectors;

// Lombok
@RequiredArgsConstructor
// Spring
@RestController
@RequestMapping("/api/v1/media/videos") // https://www.fooda.be/api/v1/media
public class VideoController {

    // INJECT_FLOW_BEANS
    private final VideoRepository imageRepository;
    private final VideoMapper mediaMapper;
    private final VideoIndexer imageIndexer;

    // CREATING_NEW_MEDIA
    // Spring
    @PostMapping(HttpEndpoints.POST_SINGLE)
    // JavaX
    @Transactional
    public ResponseEntity<String> create(@RequestBody @Valid @NotNull CreateVideoRequest request) {

        // CREATE_FLOW
        return imageRepository
                .findByUserIdAndRelatedId(request.getUserId(), request.getUserId())
                .map(entity -> mediaMapper.toEntity(request))
                .map(entity -> imageRepository.save(entity))
                .map(savedEntity -> mediaMapper.toResponse(savedEntity))
                .map(response -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .header("savedId", String.valueOf(response.getVideoId()))
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
                                         @RequestBody @Valid @NotNull UpdateVideoRequest request) {

        // UPDATE_FLOW
        return imageRepository
                .findById(id)
                .map(entity -> mediaMapper.toEntity(request, entity))
                .map(entity -> imageRepository.save(entity))
                .map(updatedEntity -> mediaMapper.toResponse(updatedEntity))
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
    public ResponseEntity<String> deleteById(@RequestParam("id") @NotNull Long id) {

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
    public ResponseEntity<List<VideoResponse>> findAll(
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER, required = false) @NotNull Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE, required = false) @NotNull Integer pageSize) {

        // BUSINESS_FLOW
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(imageRepository
                        .findAll(PageRequest.of(pageNo - 1, pageSize))
                        .stream()
                        .map(entity -> mediaMapper.toResponse(entity))
                        .collect(Collectors.toUnmodifiableList())
                );
    }

    // FIND_BY_ID
    @GetMapping(HttpEndpoints.FIND_BY_ID)
    public ResponseEntity<VideoResponse> findById(@PathVariable Long id) {

        // BUSINESS_FLOW
        return imageRepository
                .findById(id)
                .map(entity -> mediaMapper.toResponse(entity))
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
    public ResponseEntity<List<VideoResponse>> search(
            @RequestParam String keyword,
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER, required = false) @NotNull Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE, required = false) @NotNull Integer pageSize) {

        // BUSINESS_FLOW
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(imageIndexer
                        .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                        .stream()
                        .map(entity -> mediaMapper.toResponse(entity))
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
