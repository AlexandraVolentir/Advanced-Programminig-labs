import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;

/**
 * finds the mst of a graph using prim and jgrapht library
 */
public class Prim {
    DefaultDirectedGraph<String, DefaultWeightedEdge> graph;

    /**
     * default constructor for prims
     */
    Prim(){
        graph = new DefaultDirectedGraph<>(DefaultWeightedEdge.class);
    }

    /**
     *
     * @param listStreets list of Streets
     * @param nodesList list of nodes
     * @return the minimum spanning tree
     */
    PrimMinimumSpanningTree<String, DefaultWeightedEdge>
    performPrims(ArrayList<Street> listStreets, ArrayList<Intersection> nodesList){
        for(Intersection intersection : nodesList){
            graph.addVertex(intersection.getName());
        }
        for(Street street : listStreets){
            System.out.println(street.getNodeList().get(0).getName() + " " + street.getNodeList().get(1).getName() );
            graph.setEdgeWeight(graph.addEdge(street.getNodeList().get(0).getName(), street.getNodeList().get(1).getName()), street.getLength());
        }
        return new PrimMinimumSpanningTree<String, DefaultWeightedEdge>(graph);
    }
}
