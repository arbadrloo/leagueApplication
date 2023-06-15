package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.Goal;
import domian.MatchLineup;
import repository.GoalRepository;
import repository.MatchLineupRepository;
import service.GoalService;
import service.MatchLineupService;

public class GoalServiceImpl extends BaseServiceImpl<Goal, Long,
        GoalRepository>
        implements GoalService {
    public GoalServiceImpl(GoalRepository repository) {
        super(repository);
    }
}
