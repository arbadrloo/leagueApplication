package service.Impl;

import base.service.impl.BaseServiceImpl;
import domian.Goal;
import domian.Match;
import repository.MatchRepository;
import service.MatchService;

public class MatchServiceImpl extends BaseServiceImpl<Match, Long,
        MatchRepository>
        implements MatchService {

    public MatchServiceImpl(MatchRepository repository) {
        super(repository);
    }

//    @Override
//    public void getMatchInformation(Match match) {
//
//
//        int homeTeamGoals = 0;
//        int awayTeamGoals = 0;
//        int homeTeamScore = 0;
//        int awayTeamScore = 0;
//
//
//        Match myMatch = repository.getById(match.getId());
//        String homeTeamName = myMatch.getTeam().getName();
//
//        for (Goal goal: myMatch.getGoals()) {
//            if (goal.getPlayer().getTeam().equals(myMatch.getTeam())){
//                homeTeamGoals++;
//            }else {
//                awayTeamGoals++;
//            }
//        }
//
//        if (homeTeamGoals > awayTeamGoals) homeTeamScore = 3;
//        else if (homeTeamGoals < awayTeamGoals) awayTeamScore = 3;
//        else{
//            homeTeamScore = 1;
//            awayTeamScore = 1;
//        }
//        System.out.println("Home Team: "+ homeTeamName);
//        System.out.println("Away Team: "+ awayTeamName);
//
//        System.out.println(homeTeamName + "scored" + homeTeamGoals + "goal(s)");
//        System.out.println(awayTeamName + "scored" + awayTeamName + "goal(s)");
//
//        System.out.println(homeTeamName + "got" + homeTeamScore + "point(s)");
//        System.out.println(awayTeamName + "got" + awayTeamScore + "point(s)");
//
//    }
}

