package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.MatchLineup;
import repository.MatchLineupRepository;
import service.MatchLineupService;

public class MatchLineupServiceImpl extends BaseServiceImpl<MatchLineup, Long,
        MatchLineupRepository>
        implements MatchLineupService {

    public MatchLineupServiceImpl(MatchLineupRepository repository) {
        super(repository);
    }
}
