package be.fooda.backend.ranking.dao;

import be.fooda.backend.ranking.model.document.StoreDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends MongoRepository<StoreDocument, String> {


}
