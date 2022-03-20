import java.util.stream.*;

/**
 * blueprint for an intersection
 * each intersection has its own name
 */
public class Intersection {

    private String name;

    /**
     * constructor for the intersection class
     * @param name the name of the intersection
     */
    public Intersection(String name) {
        this.name = name;
    }

    /**
     * setter for the name of the intersection
     * @param name name of the intersection
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the name of the intersection
     * @return the name of the intersection
     */
    public String getName() {
        return name;
    }

    /**
     * toString method that concatenates all the data members of the interseciton
     * @return
     */
    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }
}
