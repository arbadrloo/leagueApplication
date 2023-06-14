package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domian.Stadium;
import repository.StadiumRepository;

import javax.persistence.EntityManager;

public class StadiumRepositoryImpl extends BaseRepositoryImpl<Stadium, Integer>
implements StadiumRepository {

    public StadiumRepositoryImpl(EntityManager em) {
        super(em);
    }
    @Override
    public Class<Stadium> getEntityClass() {
        return Stadium.class;
    }
}
