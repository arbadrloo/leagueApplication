package base.repository.impl;

import base.domain.BaseEntity;
import base.repository.BaseRepository;
import util.CustomEntityTransaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable>
        implements BaseRepository<T, ID> {
    protected final EntityManager em;
    private CustomEntityTransaction entityTransaction;


    public BaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public T save(T t) {
        beginTransaction(true);
        t = saveWithoutTransaction(t);
        customCommitTransaction();

        return t;
    }

    private T saveWithoutTransaction(T t) {
        if (t.getId() == null) {
            em.persist(t);
        } else {
//            em.merge(t);
            t = em.merge(t);
        }
        return t;
    }

    @Override
    public List<T> saveALl(Collection<T> tCollection) {
        beginTransaction();
        List<T> savedEntities = new ArrayList<>();
        tCollection.forEach(
                entity -> savedEntities.add(saveWithoutTransaction(entity))
        );
        commitTransaction();
        return savedEntities;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(
                em.find(
                        getEntityClass(), id
                )
        );
    }

    @Override
    public T getById(ID id) {
        return em.find(
                getEntityClass(), id
        );
    }

    @Override
    public void deleteById(ID id) {
        beginTransaction();

        em.remove(
                findById(id).orElseThrow(
                        () -> new RuntimeException("entity not found")
                )
        );

        commitTransaction();
    }

    @Override
    public List<T> findAll() {
//        criteria
        return em.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass())
                .getResultList();
    }

    @Override
    public boolean existsById(ID id) {
        TypedQuery<Long> typedQuery = em.createQuery(
                "select count(e) from " + getEntityClass().getSimpleName() + " e where e.id = :id",
                Long.class
        );
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult() > 0;
    }

    @Override
    public long count() {
        return em.createQuery(
                "select count(e) from " + getEntityClass().getSimpleName() + " e",
                Long.class
        ).getSingleResult();
    }

    @Override
    public void beginTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }

    }


    @Override
    public void commitTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }

    @Override
    public void rollbackTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }

    @Override
    public void customCommitTransaction() {
        if (this.entityTransaction != null && this.entityTransaction.isCommit()) {
            this.entityTransaction.getEntityTransaction().commit();
        }
    }

    @Override
    public void beginTransaction(boolean commit) {
        EntityTransaction transaction = em.getTransaction();
        if (!transaction.isActive()) {
            this.entityTransaction = new CustomEntityTransaction(
                    transaction, commit
            );
            transaction.begin();
        }

    }

    @Override
    public void customRollbackTransaction() {
        if (this.entityTransaction != null && this.entityTransaction.getEntityTransaction().isActive()) {
            this.entityTransaction.getEntityTransaction().rollback();
            this.entityTransaction = null;
        }
    }

    @Override
    public void changeCommitStatus(boolean commit) {
        this.entityTransaction.setCommit(commit);
    }

    public abstract Class<T> getEntityClass();
}

