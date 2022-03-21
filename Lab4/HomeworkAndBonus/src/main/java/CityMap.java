import java.util.*;

/**
 * blueprint for the representation of the city
 */
public class CityMap {

    private Map<Intersection, List<Street>> cityMap;
    // one by one (assuming e is an array of streets)
    private List<Street> streetList;

    /**
     * default constructor for the cityMap
     */
    public CityMap() {
        cityMap = new HashMap<>();
        streetList = new ArrayList<>();
    }

    /**
     * method that maps the intersection and the array of Streets that it contains
     * @param intersection the intersection object
     * @param streetList the streetList to be mapped
     */
    public void addStreet(Intersection intersection, ArrayList<Street> streetList){
        cityMap.put(intersection, streetList);
    }

    /**
     * setter for the city map
     * @param intersection the key that is actually the intersection object
     * @param streetList the value - the streetList
     */
    public void setCityMap(Intersection intersection, ArrayList<Street> streetList){
        cityMap.put(intersection, Arrays.asList(streetList.get(0), streetList.get(1)));
    }

    /**
     * getter for the cityMap
     * @return the city map
     */
    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

    /**
     * setter for the cityMap
     * @param cityMap takes the city map as a parameter
     */
    public void setCityMap(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    /**
     * getter for the streetList
     * @return the streetList
     */
    public List<Street> getStreetList() {
        return streetList;
    }

    /**
     * setter for the streetList
     * @param streetList the streetList
     */
    public void setStreetList(List<Street> streetList) {
        this.streetList = streetList;
    }
}
