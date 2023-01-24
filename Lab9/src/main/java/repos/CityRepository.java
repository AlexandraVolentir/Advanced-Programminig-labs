package repos;

import models.City;
import jakarta.persistence.EntityManager;
import models.Continent;
import utils.EntityManagerFactorySingleton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * repository for manipulating the city object
 */
public class CityRepository extends DataRepository<City, Integer> {

    /**
     * constructor for the city repository that
     * initializes the EntityManagerFactorySingleton
     */
    public CityRepository() {
        EntityManagerFactorySingleton entityManagerFactorySingleton = EntityManagerFactorySingleton.getInstance();
        setEntityManager(entityManagerFactorySingleton.getEntityManager());
    }

    /**
     * finds the city by its id by executing the query in the entity
     * @param id the id of the city
     * @return the city object
     */
    public City findById(Integer id) {
        return (City) getEntityManager().createNamedQuery("City.findById").setParameter("id", id).getSingleResult();
    }

    /**
     * find all the cities by executing the query
     * @return the list with all the present cities
     */
    public List<City> findAll() {
        return (List<City>) getEntityManager().createNamedQuery("City.findAll").getResultList();
    }

    /**
     * find the city by name
     * @param name the name of the city
     * @return the list
     */
    public List<City> findByName(String name) {
        return (List<City>) getEntityManager().createNamedQuery("City.findByName").setParameter("name", name).getResultList();
    }

    /**
     * creates the city in the database
     * @param city the city object
     */
    public void create(City city){
        beginTransaction();
        getEntityManager().persist(city);
        commit();
    }
}