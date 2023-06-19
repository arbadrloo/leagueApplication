package base.service.impl;

import base.domain.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl <T extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {

    public final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        try {
            repository.beginTransaction(true);
            t = repository.save(t);
//            repository.customCommitTransaction();
            repository.commitTransaction();
            return t;
        } catch (Exception e) {
            repository.customRollbackTransaction();
            throw e;
        }
    }

    @Override
    public List<T> saveAll(Collection<T> tCollection) {
        try {
//            repository.beginTransaction();
            List<T> entities = repository.saveALl(tCollection);
            repository.commitTransaction();
            return entities;
        } catch (Exception e) {
            repository.rollbackTransaction();
            throw e;
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T getById(ID id) {
        return repository.getById(id);
    }

    @Override
    public void deleteById(ID id) {
        repository.beginTransaction();
        repository.deleteById(id);
        repository.commitTransaction();
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }


}
