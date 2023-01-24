package daoresponses;

import services.Database;

import java.sql.*;

/**
 * Data Access class for the Continent Objects
 */
public class ContinentDAO {
    /**
     * updates the database inserting the continent specified in the continents table
     * @param name the name of the continent
     * @throws SQLException provides information on any database access error
     */
    public void create(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (PreparedStatement prepareStatement = connection.prepareStatement("insert into continents (name) values (?)")) {
            prepareStatement.setString(1, name);
            prepareStatement.executeUpdate();
        }
    }

    /**
     * finds the name of the continent by its id
     * @param name the name of the continent
     * @return the id of the continent
     * @throws SQLException provides information on any database access error
     */
    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select id from continents where name='" + name + "'")) {
            return resultSet.next() ? resultSet.getInt(1) : null;
        }
    }

    /**
     * finds a continent by its id
     * @param id the id of the continent
     * @return the name of the continent
     * @throws SQLException provides information on any database access error
     */
    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery( "select name from continents where id='" + id + "'")) {
            return resultSet.next() ? resultSet.getString(2) : null;
        }
    }

}
