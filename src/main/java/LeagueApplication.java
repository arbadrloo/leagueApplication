import domian.Team;
import domian.TeamEmployee;
import service.CityService;
import service.TeamEmployeeService;
import service.TeamService;
import util.ApplicationContext;

import java.util.HashSet;
import java.util.Set;


public class LeagueApplication {
    public static void main(String[] args) {

        TeamEmployeeService teamEmployeeService = ApplicationContext.getTeamEmployeeService();
        TeamService teamService = ApplicationContext.getTeamService();
        CityService cityService = ApplicationContext.getCityService();



//        Faker faker = new Faker();
//
        Set<TeamEmployee> teamEmployees = new HashSet<>();
//
//
//        for (int i = 0; i < 150; i++) {
//
//            TeamEmployee teamEmployee = new TeamEmployee();
//            teamEmployee.setFirstName(faker.name().firstName());
//            teamEmployee.setLastName(faker.name().lastName());
//            teamEmployee.setUsername(faker.name().username());
//            teamEmployee.setPassword(faker.internet().password(8, 16));
//            teamEmployee.setSalary(faker.number().randomDouble(2,1000,200000));
//            teamEmployees.add(teamEmployee);
//        }

//        City city =  cityService.getById(1);

//        teamEmployeeService.saveAll(teamEmployees);


//        City city = new City();
//        city.setName("Esfahan");
//        cityService.save(city);
//
//
//
//        Team team = new Team();
//        team.setName("Sepahan");
//        team.setTeamUu("SEP15465");
//        team.setCity(city);
//
//
        Team team = teamService.getById(1);

        for (Long i = 1L; i < 21 ; i++) {
             TeamEmployee myPlayer = teamEmployeeService.getById(i);
             teamEmployees.add(myPlayer);
        }
        team.setTeamEmployees(teamEmployees);
        teamService.save(team);
    }

}
