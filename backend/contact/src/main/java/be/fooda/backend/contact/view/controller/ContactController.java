package be.fooda.backend.contact.view.controller;

import be.fooda.backend.contact.dao.ContactIndexer;
import be.fooda.backend.contact.dao.ContactRepository;
import be.fooda.backend.contact.model.dto.ContactResponse;
import be.fooda.backend.contact.model.dto.CreateContactRequest;
import be.fooda.backend.contact.model.dto.UpdateContactRequest;
import be.fooda.backend.contact.model.http.HttpEndpoints;
import be.fooda.backend.contact.model.http.HttpFailureMassages;
import be.fooda.backend.contact.model.http.HttpSuccessMassages;
import be.fooda.backend.contact.service.mapper.ContactMapper;
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

import static be.fooda.backend.contact.model.http.HttpEndpoints.CONTACTS_PUT_SINGLE_TEXT;


// LOMBOK
@RequiredArgsConstructor
// SPRING
@RestController
@RequestMapping("/api/v2/contact") // https://www.fooda.be/api/v1/contact
public class ContactController {

    // INJECT_FLOW_BEAN -> must be private and final 
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final ContactIndexer contactIndexer;
    
    // CREATE_NEW_Contact
    @Transactional
    @PostMapping(HttpEndpoints.CONTACT_POST_SINGLE_TEXT)
    public ResponseEntity<String> create(@RequestBody @Valid @NotNull CreateContactRequest request) {
        
       
        if(contactRepository.existsByTitleAndUserId(request.getTitle(), request.getUserId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, HttpFailureMassages.Contact_ALREADY_EXIST.getDescription());
        }
      
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("saved_id", String.valueOf(
                        contactRepository.save(contactMapper.toEntity(request)).getId())
                )
                .body(HttpSuccessMassages.Contact_CREATED.getDescription());
    }

    // UPDATE_SINGLE_Contact
    @Transactional
    @PatchMapping(CONTACTS_PUT_SINGLE_TEXT)
    public ResponseEntity<String> updateById(@PathVariable("contactId") @Positive @NotNull Long contactId, @RequestBody @NotNull UpdateContactRequest request) {

        // FLOW_AND_RETURN
        return contactRepository
                .findById(contactId)
                .map(entity -> contactMapper.toEntity(request, entity))
                .map(entity -> contactRepository.save(entity))
                .map(entity -> ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .header("updated_id", String.valueOf(entity.getId()))
                        .body(HttpSuccessMassages.Contact_UPDATED.getDescription()))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMassages.Contact_NOT_FOUND.getDescription());
                });
    }

    // DELETE_BY_ID
    @Transactional
    @DeleteMapping(HttpEndpoints.CONTACT_DELETE_BY_ID)
    public ResponseEntity<String> deleteById(@PathVariable("contactId") @NotNull Long ContactId) {

        return contactRepository
                .findById(ContactId)
                .map(entity -> contactRepository.makePassive(entity.getId()))
                .map(deleteCount -> deleteCount > 0
                        ? ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(HttpSuccessMassages.Contact_MADE_PASSIVE.getDescription())
                        : ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(HttpFailureMassages.FAILED_TO_MAKE_Contact_PASSIVE.getDescription())
                )
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMassages.FAILED_TO_MAKE_Contact_PASSIVE.getDescription());
                });
    }

    // DELETE_BY_ID_PERMANENTLY
    @Transactional
    @DeleteMapping(HttpEndpoints.CONTACT_DELETE_BY_ID_PERMANENTLY)
    public ResponseEntity<String> deleteByIdPermanently(@PathVariable("contactId") @NotNull Long ContactId) {

        return contactRepository
                .findById(ContactId)
                .map(entity -> {
                    contactRepository.deleteById(ContactId);
                    return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .body(HttpSuccessMassages.Contact_DELETED.getDescription());
                })
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMassages.Contact_NOT_FOUND.getDescription());
                });
    }

    // @PatchMapping // UPDATE Contact(S) BUT NOT ALL THE FIELDS

    // GET_ALL
    @Transactional
    @GetMapping(HttpEndpoints.CONTACT_FIND_ALL_TEXT)
    public ResponseEntity<List<ContactResponse>> findAll(
            @RequestParam(value = HttpEndpoints.PAGE_NUMBER_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_NUMBER_DEFAULT_VALUE) Integer pageNo,
            @RequestParam(value = HttpEndpoints.PAGE_SIZE_TEXT,
                    required = false, defaultValue = HttpEndpoints.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize) {

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(
                        contactRepository
                                .findAllByIsActive(true, PageRequest.of(pageNo - 1, pageSize))
                                .stream()
                                .map(entity -> contactMapper.toResponse(entity))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // GET_BY_ID
    @Transactional
    @GetMapping(HttpEndpoints.CONTACT_FIND_BY_ID_TEXT)
    public ResponseEntity<ContactResponse> findById(@PathVariable("contactId") @NotNull Long ContactId) {

        return contactRepository
                .findById(ContactId)
                .map(entity -> contactMapper.toResponse(entity))
                .map(response -> ResponseEntity.status(HttpStatus.FOUND).body(response))
                .orElseThrow(() -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, HttpFailureMassages.Contact_NOT_FOUND.getDescription());
                });
    }

    // SEARCH(KEYWORDS)
    @Transactional
    @GetMapping(HttpEndpoints.CONTACT_SEARCH_TEXT)
    public ResponseEntity<List<ContactResponse>> search(
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
                        contactIndexer
                                .search(PageRequest.of(pageNo - 1, pageSize), keyword)
                                .stream()
                                .map(entity -> contactMapper.toResponse(entity))
                                .collect(Collectors.toUnmodifiableList())
                );
    }

    // EXISTS_BY_ID
    @Transactional
    @GetMapping(HttpEndpoints.CONTACT_FIND_EXISTS_BY_ID_TEXT)
    public ResponseEntity<String> existsById(@PathVariable("contactId") @NotNull Long ContactId) {

        return contactRepository.existsById(ContactId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMassages.Contact_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMassages.Contact_DOES_NOT_EXIST.getDescription());
    }

    // EXISTS_BY_UNIQUE_FIELDS
    @Transactional
    @GetMapping(HttpEndpoints.Contact_EXISTS_BY_UNIQUE_FIELDS)
    public ResponseEntity<String> existsByUniqueFields(@RequestParam("title") String title, @RequestParam("contactId") Long contactId) {

        return contactRepository.existsByTitleAndUserId(title, contactId)
                ? ResponseEntity.status(HttpStatus.FOUND).body(HttpSuccessMassages.Contact_EXISTS.getDescription())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpFailureMassages.Contact_DOES_NOT_EXIST.getDescription());
    }


}
