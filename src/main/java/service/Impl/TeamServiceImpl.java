package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.Goal;
import domian.Team;
import repository.TeamRepository;
import service.TeamService;
import domian.Match;

public class TeamServiceImpl extends BaseServiceImpl <Team, Integer, TeamRepository>
implements TeamService {

    public TeamServiceImpl(TeamRepository repository) {
        super(repository);
    }

    @Override
    public void calculateTotalScores(Team team) {
        int totalScore = 0;

        for (Match match : team.getMatches()) {
            for (Goal goal : match.getGoals()) {
                if (goal.getPlayer().getTeam().equals(team)) {
                    totalScore++;
                }
            }
        }


        team.setTotalScore(totalScore);
    }


}
