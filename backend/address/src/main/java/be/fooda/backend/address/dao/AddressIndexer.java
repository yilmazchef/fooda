package be.fooda.backend.address.dao;

import be.fooda.backend.address.model.entity.AddressEntity;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/* HIBERNATE SEARCH 6.0 -> Search with flow */

@Repository
public class AddressIndexer {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Page<AddressEntity> search(Pageable pageable, String keyword) {

        SearchSession session = Search.session(entityManager);

        SearchResult<AddressEntity> result = session.search(AddressEntity.class)
                .where(f -> f.match().fields(
                        "house",
                        "street" ,
                        "municipality",
                        "postcode",
                        "city",
                        "region",
                        "country",
                        "countryCode"
                ).matching(keyword).fuzzy())
                .fetch((int) pageable.getOffset(), pageable.getPageSize());

        return new PageImpl<>(result.hits(), pageable, result.total().hitCount());

    }


}
