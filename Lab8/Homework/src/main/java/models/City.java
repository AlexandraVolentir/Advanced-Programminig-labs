package models;

/**
 * stores information about a city object and contains
 * methods that can calculate the distance between cities
 */
public class City {
    private int id;
    private String country;
    private String name;
    private boolean capital;
    private double latitude;
    private double longitude;

    /**
     * the City public constructor
     * @param country the name of the country that
     * @param name the name of the city itself
     * @param capital boolean - if it is a capital or not
     * @param latitude the latitude
     * @param longitude the longitude
     */
    public City(String country, String name, boolean capital, double latitude, double longitude) {
        this.country = country;
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * calculated the distance from this city object to another
     * @param destination the destination city object
     * @return the double of the distance
     */
    public double getDistanceTo(City destination) {
        double myLatitudeInRadians = Math.toRadians(this.latitude);
        double myLongitudeInRadians = Math.toRadians(this.longitude);
        double destinationLatitudeInRadians = Math.toRadians(destination.getLatitude());
        double destinationLongitudeInRadians = Math.toRadians(destination.getLongitude());

        double distanceLatitude = destinationLatitudeInRadians - myLatitudeInRadians;
        double distanceLongitude = destinationLongitudeInRadians - myLongitudeInRadians;

        double haversineFormula = Math.pow(Math.sin(distanceLatitude / 2), 2) + Math.cos(myLatitudeInRadians) * Math.cos(destinationLatitudeInRadians) * Math.pow(Math.sin(distanceLongitude / 2),2);

        double haversineFormulaSqrt = 2 * Math.asin(Math.sqrt(haversineFormula));

        double radiusOdEarthInKilometers = 6371;

        return haversineFormulaSqrt * radiusOdEarthInKilometers;
    }

    /**
     * getter for the country
     * @return the name of the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * setter for the country
     * @param country the name of the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * getter for the name of the city
     * @return the name of the city
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name of the city
     * @param name the name fo the city
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for isCapital
     * @return the truth statement of the city being a capital
     */
    public boolean isCapital() {
        return capital;
    }

    /**
     * setter for isCapital
     */
    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    /**
     * getter for the latitude
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * setter for the latitude
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * getter for the longitude
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * setter for the longitude
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * getter for the id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * setter for the id
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * toString function for the city object
     * @return the concatenated information of the city
     */
    @Override
    public String toString() {
        return "City{" +
                "country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
