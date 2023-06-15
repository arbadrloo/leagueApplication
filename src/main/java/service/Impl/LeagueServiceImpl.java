package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.League;
import repository.LeagueRepository;
import service.LeagueService;

public class LeagueServiceImpl extends BaseServiceImpl<League, Integer,
        LeagueRepository>
        implements LeagueService {
    public LeagueServiceImpl(LeagueRepository repository) {
        super(repository);
    }


}
