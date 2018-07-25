package com.db.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaTransactionManager {

    // == constants ==
    private static final Logger log = LogManager.getLogger(JpaTransactionManager.class);

    // == attributes ==
    private static EntityManager em = EMFProducer.getInstance().getEntityManager();

    private final EntityTransaction tx = em.getTransaction();


    private static class TransactionManagerProvider {
        static final JpaTransactionManager INSTANCE = new JpaTransactionManager();
    }

    public static JpaTransactionManager getInstance() {
        return TransactionManagerProvider.INSTANCE;
    }


    // == protected methods ==
    public final void begin() {
        tx.begin();
    }

    public final void commit() {
        tx.commit();
    }

    public final <T> void saveAll(List<T> entities) {

        begin();

        for (T entity : entities) {
            save(em, entity);
        }

        commit();

        clearCache();
    }

    public final <T> T  save(T entity) {

        begin();

        save(em, entity);

        commit();

        clearCache();
        return entity;
    }

    private static <T> T save(EntityManager em, T entity) {

        Object id = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);

        if (id == null) {
            em.persist(entity);
        } else {
            entity = em.merge(entity);
        }

        return entity;
    }


    /**
     * Creates a {@link TypedQuery} to do SELECT * FROM T.

     * @param entityClass the entity class
     * @throws NullPointerException if entityClass is null.
     * @return the query to retrieve all records.
     */
    public static <T> TypedQuery<T> selectAll(  Class<T> entityClass) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> from = cq.from(entityClass);
        CriteriaQuery<T> select = cq.select(from);
        TypedQuery<T> typedQuery = em.createQuery(select);
        return typedQuery;
    }

    public static <T> TypedQuery<T> findByField( Class<T> entityClass, String attributeName, Object attributeValue) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> from = cq.from(entityClass);

        cq.where(cb.equal(from.get(attributeName), attributeValue));

        CriteriaQuery<T> select = cq.select(from);

        TypedQuery<T> typedQuery = em.createQuery(select);
        return typedQuery;
    }



    private final void clearCache() {
        log.debug("evicting cache on em= {}", em);
        em.getEntityManagerFactory().getCache().evictAll();
    }


}
