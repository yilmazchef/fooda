package be.fooda.backend.customer.dao;

import be.fooda.backend.customer.model.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
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

@Repository
public class CustomerIndexer {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Page<CustomerEntity> search(Pageable pageable, String keyword) {

        SearchSession session = Search.session(entityManager);

        SearchResult<CustomerEntity> result = session.search(CustomerEntity.class)
                .where(f -> f.match().fields(
                        "title",
                        "firstName" ,
                        "familyName",
                        "companyName",
                        "dateOfBirth",
                        "note",
                        "validation"
                ).matching(keyword).fuzzy())
                .fetch((int) pageable.getOffset(), pageable.getPageSize());

        return new PageImpl<>(result.hits(), pageable, result.total().hitCount());

    }
}
