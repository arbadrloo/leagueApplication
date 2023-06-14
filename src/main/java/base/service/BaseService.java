package base.service;

import base.domain.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {
    T save(T t);

    List<T> saveAll(Collection<T> tCollection);

    Optional<T> findById(ID id);


    public T getById(ID id);


    void deleteById(ID id);

    List<T> findAll();

    boolean existsById(ID id);

    long count();
}
