package repos;


import jakarta.persistence.EntityManager;
import models.Continent;
import utils.EntityManagerFactorySingleton;

import java.util.List;

/**
 * repository for manipulating the continent object
 */
public class ContinentRepository  extends DataRepository<Continent, Integer> {
    public ContinentRepository() {
        EntityManagerFactorySingleton entityManagerFactorySingleton = EntityManagerFactorySingleton.getInstance();
        setEntityManager(entityManagerFactorySingleton.getEntityManager());
    }

    /**
     * finds the continent by its id by executing the query in the entity
     * @param id the id of the continent
     * @return the continent object
     */
    public Continent findById(Integer id) {
        return (Continent) getEntityManager().createNamedQuery("Continent.findById").setParameter("id", id).getSingleResult();
    }

    /**
     * find the continent by name
     * @param name the name of the continent
     * @return the list
     */
    public List<Continent> findByName(String name) {
        return (List<Continent>) getEntityManager().createNamedQuery("Continent.findByName").setParameter("name", name).getResultList();
    }

    /**
     * creates the continent in the database
     * @param continent the continent object
     */
    public void create(Continent continent){
        beginTransaction();
        getEntityManager().persist(continent);
        commit();
    }
}
