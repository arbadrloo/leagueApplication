package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domian.Match;
import repository.MatchRepository;

import javax.persistence.EntityManager;

public class MatchRepositoryImpl extends BaseRepositoryImpl<Match, Long>
implements MatchRepository {
    public MatchRepositoryImpl(EntityManager em) {
        super(em);
    }
    @Override
    public Class<Match> getEntityClass() {
        return null;
    }
}
