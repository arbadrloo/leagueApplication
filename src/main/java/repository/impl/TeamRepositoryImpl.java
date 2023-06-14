package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domian.Team;
import repository.TeamRepository;

import javax.persistence.EntityManager;

public class TeamRepositoryImpl extends BaseRepositoryImpl<Team, Integer>
implements TeamRepository {

    public TeamRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Team> getEntityClass() {
        return Team.class;
    }
}
