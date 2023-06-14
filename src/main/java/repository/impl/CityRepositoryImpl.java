package repository.impl;

import base.repository.BaseRepository;
import base.repository.impl.BaseRepositoryImpl;
import domian.City;
import repository.CityRepository;

import javax.persistence.EntityManager;

public class CityRepositoryImpl extends BaseRepositoryImpl<City, Integer>
implements CityRepository {

    public CityRepositoryImpl(EntityManager em) {
        super(em);
    }
    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}
