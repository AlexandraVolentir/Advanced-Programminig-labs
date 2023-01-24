package daoresponses;

import services.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    /**
     * inserts the country in the database providing information only about its name
     * @param countryName the name of the country
     * @throws SQLException provides information on any database access error
     */
    public void create(String countryName) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement prepareStatement = connection.prepareStatement("insert into countries (name) values (?)")) {
            prepareStatement.setString(1, countryName);
            prepareStatement.executeUpdate();
        }
    }

    /**
     * inserts the country in the database providing information about its name and the name of the continent it is located
     * @param countryName the name of the country
     * @param continentName the name of the continent
     * @throws SQLException provides information on any database access error
     */
    public void create(String countryName, String continentName) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement prepareStatement = connection.prepareStatement("insert into countries (name, continent) values (?, ?)")) {
            prepareStatement.setString(1, countryName);
            prepareStatement.setString(2, continentName);
            prepareStatement.executeUpdate();
        }
    }

    /**
     * function to find the id of the country by its name
     * @param name the name of the country
     * @return the id of the country
     * @throws SQLException provides information on any database access error
     */
    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select id from countries where name='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

    /**
     * finds a country by its id
     * @param id the id of the country
     * @return the name of the country
     * @throws SQLException provides information on any database access error
     */
    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select name from countries where id='" + id + "'")) {
            return resultSet.next() ? resultSet.getString(1) : null;
        }
    }

    /**
     * Returns all the countries of a continent
     * @param continent the name of the continent
     * @return the list of countries within
     * @throws SQLException provides information on any database access error
     */
    public List<String> findByContinent(String continent) throws SQLException {
        List<String> stringList = new ArrayList<>();
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select name from countries where continent='" + continent + "'")) {
            while(resultSet.next()) {
                stringList.add(resultSet.getString(1));
            }
            return stringList;
        }
    }
}
