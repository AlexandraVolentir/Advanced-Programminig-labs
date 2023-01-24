import daoresponses.CityDAO;
import daoresponses.ContinentDAO;
import daoresponses.CountryDAO;
import models.City;
import services.Database;
import utils.Reader;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexandra & Andrei
 */

public class Main {
    private static final Database database = Database.getInstance();

    /**
     * Here the main code of the program will be executed
     * @param args main arguments
     */
    public static void main(String[] args) {
        try {
            ContinentDAO continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();

            CountryDAO countries = new CountryDAO();
            countries.create("Romania");
            countries.create("Ukraine");
            countries.create("Hungary", "Europe");
            countries.create("Deutschland", "Europe");
            Database.getConnection().commit();

            List<String> countriesList = countries.findByContinent("Europe");
            for(String country: countriesList) {
                System.out.println(country);
            }

            loadData();
            displayDistances();
            Database.getConnection().close();

        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }

    private static void loadData() throws SQLException {
        CityDAO cities = new CityDAO();
        if(cities.numberOfRowsInTable(Database.getConnection()) < 1) {
            Reader reader = new Reader();
            reader.readData("D:\\Faculta\\Anul 2\\Semestrul 2\\Programare Avansata\\Seminar\\Repo\\Week8\\concap.csv");
            Database.getConnection().commit();
        }
    }

    /**
     * displays the distances between the cities
     * @throws SQLException provides information on any database access error
     */
    private static void displayDistances() throws SQLException {
        CityDAO cities = new CityDAO();
        List<City> citiesList = cities.getAllCities(Database.getConnection());
        for(int indexFirstCity = 0 ; indexFirstCity < citiesList.size() ; ++indexFirstCity) {
            for (int indexSecondCity = indexFirstCity + 1; indexSecondCity < citiesList.size() ; ++indexSecondCity) {
                System.out.println("From " + citiesList.get(indexFirstCity).getName() + " to " + citiesList.get(indexSecondCity).getName() + " are " + citiesList.get(indexFirstCity).getDistanceTo(citiesList.get(indexSecondCity)) + " km.");
            }
        }
    }
}
