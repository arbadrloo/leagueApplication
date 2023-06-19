package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import domian.Team;
import domian.TeamEmployee;
import repository.TeamRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TeamRepositoryImpl extends BaseRepositoryImpl<Team, Integer>
implements TeamRepository {

    public TeamRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Team> getEntityClass() {
        return Team.class;
    }

    public void getMaxPaid() {
        String hqlQuery = "SELECT MAX(coach.salary) FROM TeamEmployee coach WHERE coach.class = Coach";
        Query query = em.createQuery(hqlQuery);

        Object[] result = (Object[]) query.getSingleResult();
        String coachName = (String) result[0];
        Double maxSalary = (Double) result[1];

        System.out.println("Coach with the maximum salary:");
        System.out.println("Name: " + coachName);
        System.out.println("Salary: " + maxSalary);
    }
    public void getMaxPaidPlayerSalary() {
        String hqlQuery = "SELECT MAX(coach.salary) FROM TeamEmployee coach WHERE coach.class = Coach";
        Query query = em.createQuery(hqlQuery);

        TeamEmployee result = (TeamEmployee) query.getSingleResult();

        System.out.println("Player with the maximum salary:" + result);

    }

}
