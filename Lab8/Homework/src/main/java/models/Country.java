package models;

/**
 * class that stores information on the country object
 */
public class Country {
    private int id;
    private String name;
    private String code;
    private String continent;

    /**
     * constructor for the country object
     * @param name the name of the country
     * @param code the country code
     * @param continent the continent in which the country is located
     */
    public Country(String name, String code, String continent) {
        this.name = name;
        this.code = code;
        this.continent = continent;
    }

    /**
     * returns the id of the country
     * @return the return id of the country
     */
    public int getId() {
        return id;
    }

    /**
     * setter for the id of the country
     * @param id the id of the country
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for the name of the country
     * @return the name of the country
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name of the country
     * @param name the name of the country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the code of the country
     * @return the country code
     */
    public String getCode() {
        return code;
    }

    /**
     * setter for the country code
     * @param code the country code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * getter for the continent
     * @return the name of the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * setter for the country continent
     * @param continent the name of the continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }
}
