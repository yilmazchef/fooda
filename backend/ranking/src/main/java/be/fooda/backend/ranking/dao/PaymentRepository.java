package be.fooda.backend.ranking.dao;

import be.fooda.backend.ranking.model.document.PaymentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentDocument, String> {


}
