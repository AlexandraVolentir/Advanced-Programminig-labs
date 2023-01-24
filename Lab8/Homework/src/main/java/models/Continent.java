package models;

/**
 * stores information about a continent
 */
public class Continent {
    private int id;
    private String name;

    /**
     * constructor for the continent
     * @param name the name of the continent
     */
    public Continent(String name) {
        this.name = name;
    }

    /**
     * getter for the id of the continent
     * @return the id of the continent
     */
    public int getId() {
        return id;
    }

    /**
     * setter for the id of the continent
     * @param id the id of the continent
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for the name of the continent
     * @return the name of the continent
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name of the continent
     * @param name the name of the continent
     */
    public void setName(String name) {
        this.name = name;
    }
}
