package be.fooda.backend.delivery.dao;

import org.hibernate.search.engine.search.query.SearchResult;
import be.fooda.backend.delivery.model.entity.DeliveryEntity;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class DeliveryIndexer {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Page<DeliveryEntity> search(Pageable pageable, String keyword) {
        SearchSession session = Search.session(entityManager);

        SearchResult<DeliveryEntity> result = session.search(DeliveryEntity.class)
                .where(f -> f.match()
                        .fields("note")
                        .matching(keyword).fuzzy())
                .fetch((int) pageable.getOffset(), pageable.getPageSize());

        return new PageImpl<>(result.hits(), pageable, result.total().hitCount());

    }
}
