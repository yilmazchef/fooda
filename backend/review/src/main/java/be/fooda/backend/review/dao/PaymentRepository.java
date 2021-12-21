package be.fooda.backend.review.dao;

import be.fooda.backend.review.model.document.CustomerDocument;
import be.fooda.backend.review.model.document.PaymentDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentDocument, String> {

    Page<PaymentDocument> findAllByReviewContaining(String review, Pageable pageable);
}
