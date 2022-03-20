import java.util.*;
import java.util.stream.IntStream;

/**
 * main class of the program
 */
public class Main {
    /**
     * here is where the main code will be executed
     */
    public static void main(String[] args) {
        //The simple way
        Intersection[] nodes = IntStream.rangeClosed(0, 8) .mapToObj(i -> new Intersection("vertice" + i) ) .toArray(Intersection[]::new);
        List<Intersection> nodesList =
                new ArrayList<Intersection>(Arrays.asList(nodes));

        Street street0 = new Street("street0", 2, nodesList.get(0), nodesList.get(1));
        Street street1 = new Street("street1", 3, nodesList.get(1), nodesList.get(2));
        Street street2 = new Street("street2", 1, nodesList.get(2), nodesList.get(3));
        Street street3 = new Street("street3", 1, nodesList.get(3), nodesList.get(5));
        Street street4 = new Street("street4", 1, nodesList.get(3), nodesList.get(4));
        Street street5 = new Street("street5", 2, nodesList.get(2), nodesList.get(5));
        Street street6 = new Street("street6", 1, nodesList.get(4), nodesList.get(5));
        Street street7 = new Street("street7", 3, nodesList.get(5), nodesList.get(6));
        Street street8 = new Street("street8", 3, nodesList.get(6), nodesList.get(7));
        Street street9 = new Street("street9", 1, nodesList.get(7), nodesList.get(8));
        Street street10 = new Street("street10", 2, nodesList.get(6), nodesList.get(8));
        Street street11 = new Street("street11", 2, nodesList.get(4), nodesList.get(8));
        Street street12 = new Street("street12", 2, nodesList.get(0), nodesList.get(7));
        Street street13 = new Street("street13", 2, nodesList.get(0), nodesList.get(8));

        ArrayList<Street> listStreets = new ArrayList<>();
        listStreets.add(street0);
        listStreets.add(street1);
        listStreets.add(street2);
        listStreets.add(street3);
        listStreets.add(street4);
        listStreets.add(street5);
        listStreets.add(street6);
        listStreets.add(street7);
        listStreets.add(street8);
        listStreets.add(street9);
        listStreets.add(street10);
        listStreets.add(street11);
        listStreets.add(street12);
        listStreets.add(street13);

//        listStreets.sort(
//                (Street streetNr1, Street streetNr2) ->
//                        streetNr1.getLength().compareTo(streetNr2.getLength()));
//        );
        
        listStreets.forEach(System.out::println);
        listStreets.sort(Street::compareStreetsByLength);
        System.out.println();
        listStreets.forEach(System.out::println);
        System.out.println();

        // check the properties of the hashset
        Set<Intersection> setOfIntersections = new HashSet<>(nodesList);
        setOfIntersections.add(nodesList.get(0));
        setOfIntersections.add(nodesList.get(0));
        setOfIntersections.forEach(System.out::println);
    }
}
