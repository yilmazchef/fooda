package be.fooda.backend.payment.dao;

import be.fooda.backend.payment.model.entity.FoodaPayment;
import lombok.RequiredArgsConstructor;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Repository
public class FoodaPaymentIndexRepository {

    private final EntityManager entityManager;

    private FullTextEntityManager entityManager() {
        return Search.getFullTextEntityManager(entityManager);
    }

    @Transactional
    public List<FoodaPayment> combined(Set<String> keywords, Pageable pageable) {
        return Collections.EMPTY_LIST;
    }

    @Transactional
    public List<FoodaPayment> simple(Set<String> keywords, Pageable pageable) {

        final FullTextEntityManager fullTextEntityManager = entityManager();
        //Create a Hibernate Search DSL query builder for the required entity
        QueryBuilder qb = qBuilder(fullTextEntityManager);

        return keywords.stream()
                .map(keyword -> {
                    //Generate a Lucene query using the builder
                    Query query = qb
                            .keyword()
                            .onField("note")
                            .matching(keyword)
                            .createQuery();

                    FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, FoodaPayment.class);

                    fullTextQuery.setSort(qb.sort()
                            .byField("createdTime")
                            .desc()
                            .andByScore()
                            .createSort());
                    fullTextQuery.setMaxResults(pageable.getPageSize());
                    fullTextQuery.setFirstResult(pageable.getPageNumber());

                    //returns JPA managed entities
                    return (List<FoodaPayment>) fullTextQuery.getResultList();
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<FoodaPayment> fuzzy(Set<String> keywords, Pageable pageable) {
        //Get the FullTextEntityManager
        FullTextEntityManager ftem = entityManager();

        //Create a Hibernate Search DSL query builder for the required entity
        QueryBuilder qb = qBuilder(ftem);

        return keywords.stream()
                .map(keyword -> {
                    //Generate a Lucene query using the builder with fuzzyQuery
                    Query query = qb
                            .keyword()
                            .fuzzy()
                            .withEditDistanceUpTo(2)
                            .withPrefixLength(0)
                            .onField("note")
                            .matching(keyword)
                            .createQuery();

                    FullTextQuery fullTextQuery = ftem.createFullTextQuery(query, FoodaPayment.class);

                    fullTextQuery.setSort(qb.sort()
                            .byField("createdTime")
                            .desc()
                            .andByScore()
                            .createSort());
                    fullTextQuery.setMaxResults(pageable.getPageSize());
                    fullTextQuery.setFirstResult(pageable.getPageNumber());

                    //returns JPA managed entities
                    return (List<FoodaPayment>) fullTextQuery.getResultList();
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<FoodaPayment> range(Long start, Long end, Pageable pageable) {
        //Get the FullTextEntityManager
        FullTextEntityManager ftem = entityManager();

        //Create a Hibernate Search DSL query builder for the required entity
        QueryBuilder qb = qBuilder(ftem);

        //Generate a Lucene query using the builder with fuzzyQuery
        //Generate a Lucene range query using the builder
        // Range queries search for a value in between given boundaries.
        // This can be applied to numbers, dates, timestamps, and strings.
        Query query = qb
                .range()
                .onField("id")
                .from(start)
                .to(end)
                .createQuery();

        FullTextQuery fullTextQuery = ftem.createFullTextQuery(query, FoodaPayment.class);

        fullTextQuery.setSort(qb.sort()
                .byField("createdTime")
                .desc()
                .andByScore()
                .createSort());
        fullTextQuery.setMaxResults(pageable.getPageSize());
        fullTextQuery.setFirstResult(pageable.getPageNumber());

        //returns JPA managed entities
        return (List<FoodaPayment>) fullTextQuery.getResultList();
    }

    @Transactional
    public List<FoodaPayment> wildcard(Set<String> keywords, Pageable pageable) {
        //Get the FullTextEntityManager
        FullTextEntityManager ftem = entityManager();

        //Create a Hibernate Search DSL query builder for the required entity
        QueryBuilder qb = qBuilder(ftem);

        return keywords.stream()
                .map(keyword -> {
                    //Generate a Lucene wildcard query using the builder
                    Query query = qb
                            .keyword()
                            .wildcard()
                            .onField("note")
                            .matching("1*")
                            .createQuery();

                    FullTextQuery fullTextQuery = ftem.createFullTextQuery(query, FoodaPayment.class);

                    fullTextQuery.setSort(qb.sort()
                            .byField("createdTime")
                            .desc()
                            .andByScore()
                            .createSort());
                    fullTextQuery.setMaxResults(pageable.getPageSize());
                    fullTextQuery.setFirstResult(pageable.getPageNumber());

                    //returns JPA managed entities
                    return (List<FoodaPayment>) fullTextQuery.getResultList();
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<FoodaPayment> phrase(Set<String> keywords, Pageable pageable) {
        //Get the FullTextEntityManager
        FullTextEntityManager ftem = entityManager();

        //Create a Hibernate Search DSL query builder for the required entity
        QueryBuilder qb = qBuilder(ftem);

        return keywords.stream()
                .map(keyword -> {
                    //Generate a Lucene phrase query using the builder
                    Query query = qb
                            .phrase()
                            .withSlop(1)
                            .onField("note")
                            .sentence(keyword)
                            .createQuery();

                    FullTextQuery fullTextQuery = ftem.createFullTextQuery(query, FoodaPayment.class);

                    fullTextQuery.setSort(qb.sort()
                            .byField("createdTime")
                            .desc()
                            .andByScore()
                            .createSort());
                    fullTextQuery.setMaxResults(pageable.getPageSize());
                    fullTextQuery.setFirstResult(pageable.getPageNumber());

                    //returns JPA managed entities
                    return (List<FoodaPayment>) fullTextQuery.getResultList();
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<FoodaPayment> structured(String queryString, Pageable pageable) {
        //Get the FullTextEntityManager
        FullTextEntityManager fullTextEntityManager = entityManager();

        //Create a Hibernate Search DSL query builder for the required entity
        QueryBuilder qb = qBuilder(fullTextEntityManager);

        //The following query types are supported:
        //boolean (AND using “+”, OR using “|”, NOT using “-“)
        //prefix (prefix*)
        //phrase (“some phrase”)
        //precedence (using parentheses)
        //fuzzy (fuzy~2)
        //near operator for phrase queries (“some phrase”~3)
        Query query = qb
                .simpleQueryString()
                .onField("note")
                .matching(queryString)
                .createQuery();


        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, FoodaPayment.class);

        fullTextQuery.setSort(qb.sort()
                .byField("createdTime")
                .desc()
                .andByScore()
                .createSort());
        fullTextQuery.setMaxResults(pageable.getPageSize());
        fullTextQuery.setFirstResult(pageable.getPageNumber());

        //returns JPA managed entities
        return (List<FoodaPayment>) fullTextQuery.getResultList();
    }

    @Transactional
    public List<FoodaPayment> subclass(Set<String> keywords, Pageable pageable) {

        //Get the FullTextEntityManager
        FullTextEntityManager ftem = entityManager();

        //Create a Hibernate Search DSL query builder for the required entity
        QueryBuilder qb = qBuilder(ftem);

        return keywords.stream()
                .map(keyword -> {
                    //Generate a Lucene query using the builder
                    Query query = qb
                            .keyword()
                            .onFields(
                                    "items.amount",
//                                    "items.paymentMethod.value",
                                    "user.login",
                                    "order.store.name",
                                    "user.login"
                            )
                            .matching(keyword)
                            .createQuery();

                    FullTextQuery fullTextQuery = ftem.createFullTextQuery(query, FoodaPayment.class);

                    fullTextQuery.setSort(qb.sort()
                            .byField("createdTime")
                            .desc()
                            .andByScore()
                            .createSort());
                    fullTextQuery.setMaxResults(pageable.getPageSize());
                    fullTextQuery.setFirstResult(pageable.getPageNumber());

                    //returns JPA managed entities
                    return (List<FoodaPayment>) fullTextQuery.getResultList();
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private QueryBuilder qBuilder(FullTextEntityManager fullTextEntityManager) {
        return fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(FoodaPayment.class)
                .get();
    }
}
