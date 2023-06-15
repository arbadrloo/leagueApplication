package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.Stadium;
import repository.StadiumRepository;
import service.StadiumService;

public class StadiumServiceImpl extends BaseServiceImpl<Stadium, Integer,
        StadiumRepository>
        implements StadiumService {

    public StadiumServiceImpl(StadiumRepository repository) {
        super(repository);
    }
}
