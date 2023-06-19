package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.Goal;
import repository.GoalRepository;
import service.GoalService;

public class GoalServiceImpl extends BaseServiceImpl<Goal, Long,
        GoalRepository>
        implements GoalService {
    public GoalServiceImpl(GoalRepository repository) {
        super(repository);
    }
}
