package repository.impl;

import base.repository.BaseRepository;
import base.repository.impl.BaseRepositoryImpl;
import domian.City;
import domian.Team;
import repository.CityRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CityRepositoryImpl extends BaseRepositoryImpl<City, Integer>
        implements CityRepository {

    public CityRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }

    public void getAllCitiesTeams(City city) {
        String hqlQuery = "SELECT c, t FROM City c LEFT JOIN c.teams t";

        Query query = em.createQuery(hqlQuery);

        List<Object[]> resultList = query.getResultList();

        for (Object[] result : resultList) {
            city = (City) result[0];
            Team team = (Team) result[1];

            System.out.println("City: " + city.getName());
            System.out.println("Team: " + team.getName());
            System.out.println();
        }
    }
}
