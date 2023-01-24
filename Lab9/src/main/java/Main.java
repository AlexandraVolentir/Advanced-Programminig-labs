import models.City;
import models.Continent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repos.CityRepository;
import repos.ContinentRepository;
import utils.CityReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        homework();
    }

    public static void homework(){
        long startTime;
        CityRepository cityRepository = new CityRepository();
        ContinentRepository continentRepository = new ContinentRepository();

        startTime = System.nanoTime();
        homeworkExampleFindCityById(cityRepository);
        System.out.println("homeworkExampleFindCityById: " + (System.nanoTime() - startTime)*(1e-9) + " seconds");

        startTime = System.nanoTime();
        homeworkExampleFindCityByName(cityRepository);
        System.out.println("homeworkExampleFindCityByName: " + (System.nanoTime() - startTime)*(1e-9) + " seconds");

        startTime = System.nanoTime();
        homeworkExampleFindContinentById(continentRepository);
        System.out.println("homeworkExampleFindContinentById: " + (System.nanoTime() - startTime)*(1e-9) + " seconds");

        startTime = System.nanoTime();
        homeworkExampleCityFindAll(cityRepository);
        System.out.println("homeworkExampleCityFindAll: " + (System.nanoTime() - startTime)*(1e-9) + " seconds");
    }

    public static void homeworkExampleCityFindAll(CityRepository cityRepository){
        List<City> cityList2 = cityRepository.findAll();
        for(City item : cityList2){
//            System.out.println(item.getName());
        }
    }
    public static void homeworkExampleCreateCity(CityRepository cityRepository){
        City city = new City("Testtest");
        cityRepository.create(city);
    }

    public static void homeworkExampleFindContinentById(ContinentRepository continentRepository){
        System.out.println(continentRepository.findById(14).getName());
    }

    public static void homeworkExampleFindCityById(CityRepository cityRepository){
        System.out.println(cityRepository.findById(1).getName());
    }

    public static void homeworkExampleFindCityByName(CityRepository cityRepository){
        List<City> cityList = cityRepository.findByName("Sofia");
        for(City item : cityList){
//            System.out.println(item.getId());
        }
    }

    public static void compulsory(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Continent continent = new Continent("Europe");
        entityManager.persist(continent);

//        Continent c = (Continent)em.createQuery(
//                        "select e from Continent e where e.name='Europe'")
//                .getSingleResult();
//        c.setName("Africa");
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
    public static void loadData(CityRepository cityRepository){
        CityReader reader = new CityReader();
        reader.readData("D:\\Faculta\\Anul 2\\Semestrul 2\\Programare Avansata\\Seminar\\Repo\\Week8\\worldcities.csv");
        System.out.println(cityRepository.findAll());
    }
}
