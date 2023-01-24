package utils;

import models.City;
import repos.CityRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * utility class for reading city information from a csv file
 */
public class CityReader {
    /**
     * reads the data from a csv file with the buffered reader
     * @param path the path of the csv file
     */
    public void readData(String path) {
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                if(values[0].equals("city") || values[1].equals("N/A")) {
                    continue;
                }
                insertData(values[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * inserts the city in the database
     */
    // , String capitalName, double capitalLatitude, double capitalLongitude
    private void insertData(String capitalName) {
        CityRepository cityRepository = new CityRepository();
        City city = new City(capitalName);
//        city.setIsCapital(isCapital);
        cityRepository.create(city);
    }
}
