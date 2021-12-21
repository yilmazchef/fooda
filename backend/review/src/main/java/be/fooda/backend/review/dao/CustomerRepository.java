package be.fooda.backend.review.dao;

import be.fooda.backend.review.model.document.CustomerDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerDocument, String> {

    boolean existsByUserId(Long userId);

    boolean existsBySession(String session);

    Optional<CustomerDocument> findBySession(String session);

    CustomerDocument getBySession(String session);

    Page<CustomerDocument> findAllByReviewContaining(String review, Pageable pageable);

}
