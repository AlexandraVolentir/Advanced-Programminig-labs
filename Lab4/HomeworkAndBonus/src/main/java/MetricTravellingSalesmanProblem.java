
import org.jgrapht.*;
import org.jgrapht.alg.spanning.*;
import org.jgrapht.generate.CompleteGraphGenerator;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*;

import java.util.*;

/**
 * Make a 2-approximation algo for TSP
 * The intercity distances should satisfy the triangle inequality
 * We do a depth-first ordering of the minimum spanning tree.
 * We assume that the instance satisfies the triangle inequality
 * The implementation requires the input graph to be undirected and
 * complete.
 * @param <V> graph vertex type
 * @param <E> graph edge type
 */
public class MetricTravellingSalesmanProblem<V, E> {
    CompleteGraphGenerator<String, DefaultWeightedEdge> graph =  new CompleteGraphGenerator<String, DefaultWeightedEdge>(200);

    /**
     * getter for the graph
     * @return the graph
     */
    public CompleteGraphGenerator<String, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    /**
     * setter for the graph
     * @param graph the graph as parameter
     */
    public void setGraph(CompleteGraphGenerator<String, DefaultWeightedEdge> graph) {
        this.graph = graph;
    }

    /**
     * calculate the capacity considering the load factor of 0.75 for (Linked)HashMap
     * in a way, we limit(restrain it) if it is too big
     * @param size the size of the graph
     * @return the capacity for the given size
     */
    private static int calculateCapacityForGivenDimension(int size) {
        return (int) (size / 0.75f + 1.0f);
    }

    public static <E> HashSet<E> newHashSetWithExpectedSize(int sizeActuallyExpected) {
        return new HashSet<>(calculateCapacityForGivenDimension(sizeActuallyExpected));
    }

    /**
     * Get a graph path from a list
     * @param tour1  a list containing the vertices of the tour (is modified)
     * @param givenGraph the graph
     * @return a graph path
     */
    protected GraphPath<V, E> vertexListToTour(List<V> tour1, Graph<V, E> givenGraph) {
        tour1.add(tour1.get(0));
        return convexListRepresentationToTour(tour1, givenGraph);
    }

    /**
     * From a convex List we get a graph tour
     * @param graphTour  a closed list containing the vertices of the tour
     * @param givenGraph the graph
     * @return a graph path
     */
    public GraphPath<V, E> convexListRepresentationToTour(List<V> graphTour, Graph<V, E> givenGraph) {
        assert graphTour.get(0) == graphTour.get(graphTour.size() - 1);

        List<E> givenEdges = new ArrayList<>(graphTour.size() - 1);
        double weightOfTheTour = 0;
        V vertice1 = graphTour.get(0);
        for (V vertice2 : graphTour.subList(1, graphTour.size())) {
            E edge = givenGraph.getEdge(vertice1, vertice2);
            givenEdges.add(edge);
            weightOfTheTour += givenGraph.getEdgeWeight(edge);
            vertice1 = vertice2;
        }
        return new GraphWalk<>(givenGraph, graphTour.get(0), graphTour.get(0), graphTour, givenEdges, weightOfTheTour);
    }

    /**
     * transform set to path
     * @param givenTour  a set containing the edges of the tour
     *              ( walk in a graph that does not use any edge
     *              more than once and ends up where it started)
     * @param myGraph the graph
     * @return a graph path
     */
    public GraphPath<V, E> transformEdgesToTour(Set<E> givenTour, Graph<V, E> myGraph) {
        List<V> listOfVertices = new ArrayList<>(givenTour.size() + 1);

        MaskSubgraph<V, E> tourOfTheGraph =
                new MaskSubgraph<>(myGraph, vertex -> false, edge -> !givenTour.contains(edge));
        new DepthFirstIterator<>(tourOfTheGraph).forEachRemaining(listOfVertices::add);
        return vertexListToTour(listOfVertices, myGraph);
    }

    /**
     * Creates a tour for a graph with 1 vertex
     * @param myGraph The graph
     * @return A tour with a single vertex
     */
    protected GraphPath<V, E> tourForAGraphWithOneVertex(Graph<V, E> myGraph) {
        assert myGraph.vertexSet().size() == 1;
        V startVertex = myGraph.vertexSet().iterator().next();
        return new GraphWalk<>(
                myGraph, startVertex, startVertex, Collections.singletonList(startVertex), Collections.emptyList(), 0d);
    }

    /**
     * The graph should be undirected, complete, and non-empty
     * @param myGraph the graph
     */
    protected void validateGraph(Graph<V, E> myGraph) {
        checkIfTheGraphIsntEmpty(myGraph);
        if (!GraphTests.isComplete(myGraph)) {
            throw new IllegalArgumentException("NOT COMPLETE!");
        }
    }

    /**
     * checks if the graph is empty
     * @param myGraph the given graph
     */
    protected void checkIfTheGraphIsntEmpty(Graph<V, E> myGraph) {
        if (myGraph.vertexSet().isEmpty()) {
            throw new IllegalArgumentException("Graph contains no vertices");
        }
    }

    /**
     * Computes a 2-approximate tour
     * @param givenGraph the input graph
     * @return a tour
     */
    public GraphPath<V, E> explicitlyCallTheTour(Graph<V, E> givenGraph) {
        validateGraph(givenGraph);
        Set<V> setOfVertices = givenGraph.vertexSet();
        int size = setOfVertices.size();
        if (setOfVertices.size() == 1) {
            return tourForAGraphWithOneVertex(givenGraph);
        }

        // MST
        Graph<V, DefaultEdge> minimumSpanningTree = new SimpleGraph<V, DefaultEdge>(DefaultWeightedEdge.class);
        setOfVertices.forEach(minimumSpanningTree::addVertex);
        for (E e : new KruskalMinimumSpanningTree<>(givenGraph).getSpanningTree().getEdges()) {
            minimumSpanningTree.addEdge(givenGraph.getEdgeSource(e), givenGraph.getEdgeTarget(e));
        }

        // DFS
        Set<V> foundSet = newHashSetWithExpectedSize(size);
        List<V> tourList = new ArrayList<>(size + 1);
        V startVertice = setOfVertices.iterator().next();
        Iterator<V> dfsIt = new DepthFirstIterator<>(minimumSpanningTree, startVertice);
        while (dfsIt.hasNext()) {
            V vertice = dfsIt.next();
            if (foundSet.add(vertice)) {
                tourList.add(vertice);
            }
        }
        // Create the tour
        return vertexListToTour(tourList, givenGraph);
    }

    /**
     * convert the instance of the problem to the graph
     * @param listStreets the list of streets in the city
     * @param nodesList the list of intersections
     */
    void convertInstanceToGraph(ArrayList<Street> listStreets, ArrayList<Intersection> nodesList) {
        var completeGraph = new SimpleWeightedGraph<String, DefaultEdge>(DefaultEdge.class);
        CompleteGraphGenerator<String, DefaultEdge> completeGenerator
                = new CompleteGraphGenerator<>(nodesList.size());
        VertexFactory<String> vFactory = new VertexFactory<String>() {
            private int id = 0;
            public String createVertex() {
                return nodesList.get(id++).getName();
            }
        };
        completeGenerator.generateGraph(completeGraph, vFactory, null);
        System.out.println(explicitlyCallTheTour((Graph<V, E>) completeGraph).getGraph());
    }

    @Override
    public String toString() {
        return "MetricTSP{" +
                "graph=" + graph +
                '}';
    }
}
