import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.*;
import java.util.stream.Collectors;
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
        ArrayList<Intersection> nodesList =
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


        nodesList.forEach(System.out::println);
        ArrayList<Street> listStreets = new ArrayList<>(Arrays.asList(street0,
                street1, street2, street3,
                street4, street5, street6,
                street7, street8, street9,
                street10, street11, street12,
                street13));
        
        listStreets.forEach(System.out::println);
        listStreets.sort(Street::compareStreetsByLength);
        System.out.println();
        listStreets.forEach(System.out::println);
        System.out.println();

        Set<Intersection> setOfIntersections = new HashSet<>(nodesList);
        setOfIntersections.add(nodesList.get(0));
        setOfIntersections.add(nodesList.get(0));
        setOfIntersections.forEach(System.out::println);
        CityMap cityMap = new CityMap();

        System.out.println("\nFiltered streets: ");
        List<Street> filteredList = listStreets.stream()
                .filter(i -> i.getLength()>2)
                .filter(i -> i.findNumberOfJoinedStreets(i, listStreets) >= 3)
                .collect(Collectors.toList());
        System.out.println();
        List<Street> filteredList2 = listStreets.stream()
                .peek(i -> i.findNumberOfJoinedStreets(i, listStreets))
                .collect(Collectors.toList());
        filteredList2.forEach(System.out::println);
        System.out.println();
//        filteredList.forEach(System.out::println);
//        List<Intersection> result = nodesList.stream() .filter(v -> cityMap.get(v).containsAll(target)) .collect(Collectors.toList<>);

        Prim prim = new Prim();
        System.out.println(prim.performPrims(listStreets, nodesList).getSpanningTree());
        
    }
}
