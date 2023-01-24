package repos;

import jakarta.persistence.EntityManager;
import models.Country;
import models.Country;
import utils.EntityManagerFactorySingleton;

import java.util.List;

/**
 * repository for manipulating the country object
 */
public class CountryRepository  extends DataRepository<Country, Integer> {
    /**
     * constructor for the country repository that
     * initializes the EntityManagerFactorySingleton
     */
    public void CountryRepository() {
        EntityManagerFactorySingleton entityManagerFactorySingleton = EntityManagerFactorySingleton.getInstance();
        setEntityManager(entityManagerFactorySingleton.getEntityManager());
    }

    /**
     * finds the country by its id by executing the query in the entity
     * @param id the id of the country
     * @return the country object
     */
    public Country findById(Integer id) {
        return (Country) getEntityManager().createNamedQuery("Country.findById").setParameter("id", id).getSingleResult();
    }

    public List<Country> findByName(String name) {
        return (List<Country>) getEntityManager().createNamedQuery("Country.findByName").setParameter("name", name).getResultList();
    }

    /**
     * creates the country in the database
     * @param country the country object
     */
    public void create(Country country){
        beginTransaction();
        getEntityManager().persist(country);
        commit();
    }
}
