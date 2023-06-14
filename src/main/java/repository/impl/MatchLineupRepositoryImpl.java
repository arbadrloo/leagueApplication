package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domian.MatchLineup;
import repository.MatchLineupRepository;

import javax.persistence.EntityManager;

public class MatchLineupRepositoryImpl extends BaseRepositoryImpl<MatchLineup, Long>
implements MatchLineupRepository {

    public MatchLineupRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<MatchLineup> getEntityClass() {
        return MatchLineup.class;
    }
}
