import com.github.javafaker.Faker;
import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.VertexFactory;
import org.jgrapht.generate.CompleteGraphGenerator;
import org.jgrapht.generate.GnpRandomBipartiteGraphGenerator;
import org.jgrapht.generate.GnpRandomGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.ListenableUndirectedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;
import java.util.stream.IntStream;

/**
 * main class of the program
 */
public class Main {
    /**
     * here is where the main code will be executed
     */
    void randomInstanceGenerator(ArrayList<Intersection> nodesList){

        CompleteGraphGenerator<String, DefaultEdge> completeGenerator
                = new CompleteGraphGenerator<>(nodesList.size());
        VertexFactory<String> vFactory = new VertexFactory<String>() {
            private int id = 0;
            public String createVertex() {
                return nodesList.get(id++).getName();
            }
        };
        var completeGraph = new SimpleWeightedGraph<String, String>((EdgeFactory<String, String>) vFactory);
        Map<String, String> map = new HashMap<>();
        Random rand = new Random();
        Graph<String, DefaultWeightedEdge>  newGraph = new ListenableUndirectedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        GnpRandomGraphGenerator<String, DefaultWeightedEdge> graphGenerator = new GnpRandomGraphGenerator<>(10, 0.5, rand,false);
        graphGenerator.generateGraph(newGraph, vFactory, map);
    }

    public static void main(String[] args) {
        //The simple way
        // COMPULSORY
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

        // HOMEWORK

        // generate random fake names for intersections and streets
        Faker faker = new Faker();
        for(var intersection : nodesList){
            intersection.setName(faker.address().firstName());
        }

        for(var street: listStreets){
            street.setName(faker.address().streetAddress());
        }

        String streetAddress = faker.address().streetAddress();
        String name = faker.address().cityName();

        System.out.println(name);

        // create the city map
        HashMap<Intersection, ArrayList<Street>> mapIntersectionsToStreets = new HashMap<>();
        for(var intersection : nodesList){
            ArrayList<Street> newListOfStreets = new ArrayList<>();
            for(var street : listStreets){
                if((street.getNodeList().get(0) == intersection) || ((street.getNodeList().get(1) == intersection)) &&
                    !newListOfStreets.contains(street)){
                    newListOfStreets.add(street);
                }
            }
            mapIntersectionsToStreets.put(intersection, newListOfStreets);
        }

        System.out.println();
        CityMap cityMap = new CityMap(mapIntersectionsToStreets);
        System.out.println(cityMap);

        Set<Intersection> setOfIntersections = new HashSet<>(nodesList);
        setOfIntersections.add(nodesList.get(0));
        setOfIntersections.add(nodesList.get(0));
        setOfIntersections.forEach(System.out::println);

        // Filtering
        System.out.println("\nFiltered streets: ");
        listStreets.stream()
                .filter(v -> ((cityMap.getCityMap()).get(v.getNodeList().get(0)).size() + (cityMap.getCityMap()).get(v.getNodeList().get(1)).size() >= 3))
                .filter(i -> i.getLength()>2)
                .forEach(System.out::println);

        Prim prim = new Prim();
        System.out.println(prim.performPrims(listStreets, nodesList).getSpanningTree());

        System.out.println();

        // BONUS
        System.out.println("metricTSP");
        MetricTravellingSalesmanProblem<String, DefaultWeightedEdge> metricTravellingSalesmanProblem = new MetricTravellingSalesmanProblem<String, DefaultWeightedEdge>();
        metricTravellingSalesmanProblem.convertInstanceToGraph(listStreets, nodesList);
//        System.out.println(metricTSP);
    }
}
