package be.fooda.backend.contact.dao;

import be.fooda.backend.contact.model.entity.ContactEntity;
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
public class ContactIndexer {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Page<ContactEntity> search(Pageable pageable, String keyword) {
        SearchSession session = Search.session(entityManager);

        SearchResult<ContactEntity> result = session.search(ContactEntity.class)
                .where(f -> f.match()
                        .fields("firstName", "familyName", "companyName", "mobilePhoneNumber", "email", "title")
                        .matching(keyword).fuzzy())
                .fetch((int) pageable.getOffset(), pageable.getPageSize());

        return new PageImpl<>(result.hits(), pageable, result.total().hitCount());

    }


}
