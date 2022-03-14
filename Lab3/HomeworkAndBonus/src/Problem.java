// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;

class Problem {

    private int numberOfVertices;
    private int[][] adjacencyMatrix;
    private int source, destination, solution;
    private int solArr[];
    private final int MAX = 1000;
    private Network n1;
    public Problem(Network n1, int length) {
        numberOfVertices = length;
        this.n1 = n1;
        generateAdjacencyList(n1,length);
    }

    public void generateAdjacencyList(Network n1, int len){
        adjacencyMatrix = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                adjacencyMatrix[i][j] = 0;
            }
        }

        for(var obj : n1.getListOfNodes()){
            for (Map.Entry<Node, Integer> entry : obj.getCost().entrySet()) {
                if(obj.getId() == Node.getIdCounter() -1) break;
//                System.out.println("ID " + obj.getId() + " id counter " + Node.getIdCounter());
                Node key = entry.getKey();
                Integer value = entry.getValue();
//                System.out.println(obj.getId() + " " + key.getId() + " value: " + value);
                adjacencyMatrix[obj.getId()][ key.getId()] = value;
            }
        }
    }

    int getMinDist(int[] deistance, Boolean[] sptSet)
    {
        int minimum = MAX, minimalIndeces = -1;
        for (int adj = 0; adj < numberOfVertices; adj++)
            if (!sptSet[adj] && deistance[adj] <= minimum) {
                minimum = deistance[adj];
                minimalIndeces = adj;
            }
        return minimalIndeces;
    }

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
}