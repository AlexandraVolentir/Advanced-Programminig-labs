import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alexandra & Andrei
 */

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        try {
            ContinentDAO continents = new ContinentDAO();
            continents.create("Europe");
            database.getConnection().commit();

            CountryDAO countries = new CountryDAO();
            countries.create("Romania");
            countries.create("Ukraine");
            countries.create("Hungary", "Europe");
            countries.create("Deutschland", "Europe");
            database.getConnection().commit();

            List<String> countriesList = countries.findByContinent("Europe");
            for(String country: countriesList) {
                System.out.println(country);
            }

            database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            database.rollback();
        }
    }
}
