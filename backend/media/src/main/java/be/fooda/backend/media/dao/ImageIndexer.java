package be.fooda.backend.media.dao;

import be.fooda.backend.media.model.entity.ImageEntity;
import org.hibernate.search.engine.search.query.SearchResult;
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
public class ImageIndexer {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Page<ImageEntity> search(Pageable pageable, String keyword) {
        SearchSession session = Search.session(entityManager);

        SearchResult<ImageEntity> result = session.search(ImageEntity.class)
                .where(f -> f.match().fields("altText").matching(keyword).fuzzy())
                .fetch((int) pageable.getOffset(), pageable.getPageSize());

        return new PageImpl<>(result.hits(), pageable, result.total().hitCount());

    }


}
