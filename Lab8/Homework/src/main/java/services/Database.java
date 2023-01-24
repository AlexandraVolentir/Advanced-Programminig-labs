package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The database class stores credentials for the future database
 * It is a singleton and returns only one instance of the db
 */
public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/compulsory";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Sanda";
    private static Connection connection = null;
    private static Database databaseInstance = null;

    /**
     * the private contructor of the database
     */
    private Database() {

    }

    /**
     * function that returns a unique instance of the database
     * @return the database instance
     */
    public static Database getInstance() {
        if(databaseInstance == null) {
            databaseInstance = new Database();
            createConnection();
        }
        return databaseInstance;
    }

    /**
     * getter for the connection
     * @return the connection
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * creates the connection with the DriverManager
     * in order to create the connection, the credentials are needed (URL, USER, PASSWORD)
     */
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * closes the connection
     */
    public static void closeConnection() {

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * executes rollback on the conneciton
     */
    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
