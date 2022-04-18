package utilities;

/**
 * random generator for a given interval
 */
public class RandomGenerator {
    /**
     * gets a number for the given interval, the min - inclusively, the maximum - exclusively
     * @param min - the minimum of the interval
     * @param max the maximum of the interval
     * @return the radnom number
     */
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min); //[min, max)
    }
}
