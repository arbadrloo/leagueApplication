package service;

import base.service.BaseService;
import domian.Team;

public interface TeamService extends BaseService<Team, Integer> {

    public void calculateTotalScores(Team team);
}
