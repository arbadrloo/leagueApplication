package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.City;
import repository.CityRepository;
import service.CityService;

public class CityServiceImpl extends BaseServiceImpl<City, Integer,
        CityRepository>
        implements CityService {

    public CityServiceImpl(CityRepository repository) {
        super(repository);
    }
}
