package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domian.Goal;
import repository.GoalRepository;

import javax.persistence.EntityManager;

public class GoalRepositoryImpl extends BaseRepositoryImpl<Goal, Long>
implements GoalRepository {

    public GoalRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Goal> getEntityClass() {
        return Goal.class;
    }
}
