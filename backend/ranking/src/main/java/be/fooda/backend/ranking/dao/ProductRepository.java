package be.fooda.backend.ranking.dao;

import be.fooda.backend.ranking.model.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductDocument, String> {


}
