package service;

import base.service.BaseService;
import domian.Match;

public interface MatchService extends BaseService<Match, Long> {

    public void getMatchInformation(Match match);
}
