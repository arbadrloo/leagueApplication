package base.repository;

import base.domain.BaseEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseEntity<ID>, ID
        extends Serializable> {
    T save(T t);

    List<T> saveALl(Collection<T> tCollection);

    Optional<T> findById(ID id);

    void deleteById(ID id);

    List<T> findAll();

    boolean existsById(ID id);
    long count();

    void beginTransaction();
    void commitTransaction();
    void customCommitTransaction();
    void beginTransaction(boolean commit);
    void rollbackTransaction();
    void customRollbackTransaction();
    void changeCommitStatus(boolean commit);
    T getById(ID id);


}
