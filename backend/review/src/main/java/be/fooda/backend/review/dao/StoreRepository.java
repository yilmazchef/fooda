package be.fooda.backend.review.dao;

import be.fooda.backend.review.model.document.ProductDocument;
import be.fooda.backend.review.model.document.StoreDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends MongoRepository<StoreDocument, String> {

    Page<StoreDocument> findAllByReviewContaining(String review, Pageable pageable);
}
