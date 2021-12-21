package be.fooda.backend.ranking.dao;

import be.fooda.backend.ranking.model.document.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerDocument, String> {

    boolean existsByUserId(String userId);

    boolean existsBySession(String session);

    Optional<CustomerDocument> findBySession(String session);

    CustomerDocument getBySession(String session);


    // TODO: will be used in Review module
//    Page<CustomerDocument> findAllByCommentContaining(String comment, Pageable page);

}
