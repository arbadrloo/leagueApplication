package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.City;
import domian.Team;
import repository.CityRepository;
import service.CityService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CityServiceImpl extends BaseServiceImpl<City, Integer,
        CityRepository>
        implements CityService {

    public CityServiceImpl(CityRepository repository) {
        super(repository);
    }


}

