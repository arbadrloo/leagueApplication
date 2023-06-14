package repository.impl;

import base.repository.BaseRepository;
import base.repository.impl.BaseRepositoryImpl;
import domian.TeamEmployee;
import repository.TeamEmployeeRepository;

import javax.persistence.EntityManager;

public class TeamEmployeeRepositoryImpl extends BaseRepositoryImpl<TeamEmployee, Long>
implements TeamEmployeeRepository {

    public TeamEmployeeRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<TeamEmployee> getEntityClass() {
        return TeamEmployee.class;
    }
}
