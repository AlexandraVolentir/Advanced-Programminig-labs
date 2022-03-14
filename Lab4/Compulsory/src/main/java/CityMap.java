import java.util.*;

public class CityMap {
    private Map<Intersection, List<Street>> cityMap;
    // one by one (assuming e is an array of streets)
    private List<Street> streetList;

    public CityMap() {
        cityMap = new HashMap<>();
        streetList = new ArrayList<>();
    }

    public void addStreet(Intersection intersection, ArrayList<Street> streetList){
        cityMap.put(intersection, streetList);
    }

    public void setCityMap(Intersection intersection, ArrayList<Street> streetList){
        cityMap.put(intersection, Arrays.asList(streetList.get(0), streetList.get(1)));
    }

    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public List<Street> getStreetList() {
        return streetList;
    }

    public void setStreetList(List<Street> streetList) {
        this.streetList = streetList;
    }
}
