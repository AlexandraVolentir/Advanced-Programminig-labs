// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;

/**
 * Problem class that solves Djikstra
 */
class Problem {

    /**
     * constructor for the djikstra problem class
     */
    public Problem(Network n1, int length) {
        numberOfVertices = length;
        this.n1 = n1;
        generateAdjacencyList(n1,length);
    }

    /**
     * utility function for calculating logarithms
     */
    private double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }

    /**
     * generate an adjacency matrix
     */
    public void generateAdjacencyList(Network n1, int len){
        adjacencyMatrix = new int[len][len];
        failureProbabilityMatrix = new double[len][len];
        logarithmicFailureProbability = new double[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                adjacencyMatrix[i][j] = 0;
                failureProbabilityMatrix[i][j] = 0;
                logarithmicFailureProbability[i][j] = 0;
            }
        }
        array = n1.getListOfNodes();
        for(var obj : n1.getListOfNodes()){
            for (Map.Entry<Node, Integer> entry : obj.getCost().entrySet()) {
                if(obj.getId() == Node.getIdCounter() -1) break;
                Node key = entry.getKey();
                Integer value = entry.getValue();
                adjacencyMatrix[obj.getId()][ key.getId()] = value;
            }
        }

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                failureProbabilityMatrix[i][j] = (double)adjacencyMatrix[i][j]/100;
                logarithmicFailureProbability[i][j] =  -(double) customLog(2, 1 - failureProbabilityMatrix[i][j]);
            }
        }
    }

    double getMinDist(double[] distance, Boolean[] sptSet)
    {
        double minimum = MAX, minimalIndeces = -1;
        for (int adj = 0; adj < numberOfVertices; adj++)
            if (!sptSet[adj] && distance[adj] <= minimum) {
                minimum = distance[adj];
                minimalIndeces = adj;
            }
        return minimalIndeces;
    }

    /**
     * finding the vertex with minimum distance
     * @param distance distances
     * @param shortestPathTreeSet a set of shortest path trees
     * @return the minimal index
     */
    public int getMinDist(int[] distance, Boolean[] shortestPathTreeSet)
    {
        int minimum = MAX, minimalIndeces = -1;
        for (int adj = 0; adj < numberOfVertices; adj++)
            if (!shortestPathTreeSet[adj] && distance[adj] <= minimum) {
                minimum = distance[adj];
                minimalIndeces = adj;
            }
        return minimalIndeces;
    }

    /**
     * returns the shortest path solution
     */
    public int getSolution(int[] distance)
    {
        System.out.println("V ====>  Shortest path");
        for (int i = 0; i < numberOfVertices; i++)
        {
            if(i >= source && i <= destination)
            System.out.println(i + " \t\t " + distance[i]);
            if(i == destination){
                solution = distance[i];
                break;
            }
        }
        return solution;
    }

    /**
     * iterate and output the safest solution
     */
    public double getSafestSolution(double[] distance)
    {
        System.out.println("V ====>  Safest path");
        for (int i = 0; i < numberOfVertices; i++)
        {
            if(i >= source && i <= destination)
                System.out.println(i + " \t\t " + distance[i]);
            if(i == destination){
                solution2 = distance[i];
                break;
            }
        }
        return solution2;
    }

    /**
     * find the shortest path for all vertices using djikstra
     * firt we will choose the minimum distance node from the set of nodes
     * adj will always have the value of src in first iteration
     */
    public int[] findShortestPath(int[] distance, int sourceV, Boolean[] shortestPathTree){
        distance[sourceV] = 0;
        for (int calculate = 0; calculate < numberOfVertices - 1; calculate++) {
            int vertice = getMinDist(distance, shortestPathTree);
            shortestPathTree[vertice] = true;
            for (int adj = 0; adj < numberOfVertices; adj++)
                if (!shortestPathTree[adj] && adjacencyMatrix[vertice][adj] != 0 &&
                        distance[vertice] != MAX &&
                        distance[vertice] + adjacencyMatrix[vertice][adj] < distance[adj])
                    distance[adj] = distance[vertice] + adjacencyMatrix[vertice][adj];
        }
        return distance;
    }

    /**
     * initialize the arrays and call the simple djikstra
     */
    void performDijkstra(int sourceV, int destination) {
        this.source = sourceV;
        this.destination = destination;
        Boolean[] shortestPathTree = new Boolean[numberOfVertices];
        int[] distance = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            distance[i] = MAX;
            shortestPathTree[i] = false;
        }
        distance = findShortestPath(distance,sourceV,shortestPathTree);
        getSolution(distance);
    }

    /**
     * use djikstra with logarithmicFailureProbability in order to find the safest path
     */
    public double[] findSafestPath(double[] distance, int sourceV, Boolean[] shortestPathTree){
        distance[sourceV] = 0;
        for (int calculate = 0; calculate < numberOfVertices - 1; calculate++) {
            int vertice = (int)getMinDist(distance, shortestPathTree);
            shortestPathTree[vertice] = true;

            for (int adj = 0; adj < numberOfVertices; adj++)
                if (!shortestPathTree[adj] && logarithmicFailureProbability[vertice][adj] != 0 &&
                        distance[vertice] != MAX &&
                        distance[vertice] + logarithmicFailureProbability[vertice][adj] < distance[adj])

                    distance[adj] = (distance[vertice] + logarithmicFailureProbability[vertice][adj]);
        }
        return  distance;
    }

    /**
     * function designed to initialize parameters for the function findSafestDjikstra
     */
    void performSafestDijkstra(int sourceV, int destination) {

        this.source = sourceV;
        this.destination = destination;
        Boolean[] shortestPathTree = new Boolean[numberOfVertices];
        double[] distance = new double[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            distance[i] = MAX;
            shortestPathTree[i] = false;
        }
        distance = findSafestPath(distance,sourceV,shortestPathTree);
        getSafestSolution(distance);
    }

    private int numberOfVertices;
    private int[][] adjacencyMatrix;
    private double[][] failureProbabilityMatrix;
    private double[][] logarithmicFailureProbability;
    private int source, destination, solution;
    private double solution2;
    private int solArr[];
    private ArrayList<Node> array;
    private final int MAX = 1000;
    private Network n1;
}