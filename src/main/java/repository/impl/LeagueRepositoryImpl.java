package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domian.League;
import repository.LeagueRepository;

import javax.persistence.EntityManager;

public class LeagueRepositoryImpl extends BaseRepositoryImpl<League, Integer>
implements LeagueRepository {

    public LeagueRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<League> getEntityClass() {
        return League.class;
    }
}
