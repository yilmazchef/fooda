package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.document.BasketDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface BasketRepository extends MongoRepository<BasketDocument, String> {

    Boolean existsBySession(String session);

    Boolean existsBySessionAndCustomer_customerIdAndStore_StoreId(String session, Long customerId, Long storeId);

    Boolean existsBySessionAndStore_StoreId(@NotNull String session, Long storeId);

    BasketDocument findByStore_StoreId(Long storeId);
    // update ProductDocument set quantity = ... where productId = ...;
    //BasketDocument update

    List<BasketDocument> findBySession(String session);

    List<BasketDocument> findAllByCustomer_CustomerId(Long customerId);
    Page<BasketDocument> findAllByCustomer_CustomerId(Long customerId, Pageable pageable);

    List<BasketDocument> findAllByStore_StoreId(Long storeId);

    Page<BasketDocument> findAllByStore_StoreId(Long storeId, Pageable pageable);

    List<BasketDocument> findAllByCustomer_CustomerIdAndStore_StoreId(Long customerId, Long storeId);

    Page<BasketDocument> findAllByCustomer_CustomerIdAndStore_StoreId(Long customerId, Long storeId, Pageable pageable);

    BasketDocument getByCustomer_CustomerIdAndStore_StoreId(Long customerId, Long storeId);

    BasketDocument getBySessionAndStore_StoreId( String session, Long storeId);

    BasketDocument getBySession(String session);

    Optional<BasketDocument> findBySessionAndStore_StoreId(String session, Long storeId);
}
