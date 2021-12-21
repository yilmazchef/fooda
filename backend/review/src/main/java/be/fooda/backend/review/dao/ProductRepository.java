package be.fooda.backend.review.dao;

import be.fooda.backend.review.model.document.PaymentDocument;
import be.fooda.backend.review.model.document.ProductDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductDocument, String> {

    Page<ProductDocument> findAllByReviewContaining(String review, Pageable pageable);
}
