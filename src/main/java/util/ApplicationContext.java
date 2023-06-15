package util;

import repository.*;
import repository.impl.*;
import service.*;
import service.Impl.*;

import javax.persistence.*;

public class ApplicationContext {
    private static final EntityManager em =
            Persistence.createEntityManagerFactory(
                    "default"
            ).createEntityManager();

    private static TeamRepository teamRepository;
    private static TeamService teamService;
    private static MatchRepository matchRepository;
    private static MatchService matchService;
    private static StadiumRepository stadiumRepository;
    private static StadiumService stadiumService;
    private static MatchLineupRepository matchLineupRepository;
    private static MatchLineupService matchLineupService;
    private static GoalRepositoryImpl goalRepository;
    private static GoalService goalService;
    private static CityRepository cityRepository;
    private static CityService cityService;

    public static TeamRepository getTeamRepository() {
        if (teamRepository == null) {
            teamRepository = new TeamRepositoryImpl(em);
        }
        return teamRepository;
    }

    public static TeamService getTeamService() {
        if (teamService == null) {
            teamService = new TeamServiceImpl(
                    getTeamRepository()
            );
        }
        return teamService;
    }

    public static MatchRepository getMatchRepository() {
        if (matchRepository == null) {
            matchRepository = new MatchRepositoryImpl(em);
        }
        return matchRepository;
    }

    public static MatchService getMatchService() {
        if (matchService == null) {
            matchService = new MatchServiceImpl(getMatchRepository());
        }
        return matchService;
    }

    public static StadiumRepository getStadiumRepository() {
        if (stadiumRepository == null) {
            stadiumRepository = new StadiumRepositoryImpl(em);
        }
        return stadiumRepository;
    }

    public static StadiumService getStadiumService() {
        if (stadiumService == null) {
            stadiumService = new StadiumServiceImpl(getStadiumRepository());
        }
        return stadiumService;
    }

    public static MatchLineupRepository getMatchLineupRepository() {
        if (matchLineupRepository == null) {
            matchLineupRepository = new MatchLineupRepositoryImpl(em);
        }
        return matchLineupRepository;
    }

    public static MatchLineupService getMatchLineupService() {
        if (matchLineupService == null) {
            matchLineupService = new MatchLineupServiceImpl(getMatchLineupRepository());
        }
        return matchLineupService;
    }

    public static GoalRepository getgoalRepository() {
        if (goalRepository == null) {
            goalRepository = new GoalRepositoryImpl(em);
        }
        return goalRepository;
    }

    public static GoalService getGoalService() {
        if (goalService == null) {
            goalService = new GoalServiceImpl(getgoalRepository());
        }
        return goalService;
    }

    public static CityRepository getCityRepository() {
        if (cityRepository == null) {
            cityRepository = new CityRepositoryImpl(em);
        }
        return cityRepository;
    }

    public static CityService getCityService() {
        if (cityService == null) {
            cityService = new CityServiceImpl(getCityRepository());
        }
        return cityService;
    }


}
