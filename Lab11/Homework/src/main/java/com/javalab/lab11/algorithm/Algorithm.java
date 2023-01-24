package com.javalab.lab11.algorithm;

import com.javalab.lab11.models.Person;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class that determines all persons who are so important to the social network such that, if one of them were eliminated,
 * the network would become disconnected. For this we found all cut vertices.
 * A vertex in an undirected connected graph is an articulation point (or cut vertex) if removing it (and edges through it)
 * disconnects the graph.
 */
public class Algorithm {
    public static Set<Person> getArticulationPoints(Graph<Person, DefaultEdge> graph) {
        Map<Person, Boolean> visited = new HashMap<>();
        Map<Person, Integer> discoveryTimes = new HashMap<>();
        Map<Person, Integer> low = new HashMap<>();
        Map<Person, Person> parent = new HashMap<>();
        Set<Person> articulationPoints = new HashSet<>();
        int time = 0;

        for (Person person : graph.vertexSet()) {
            parent.put(person, null);
            visited.put(person, false);
            discoveryTimes.put(person, Integer.MAX_VALUE);
            low.put(person, 0);
        }

        for (Person person : graph.vertexSet()) {
            if (!visited.get(person)) {
                time = articulationPointsUtil(person, graph, visited, discoveryTimes, low, parent, articulationPoints, time);
            }
        }

        return articulationPoints;
    }

    private static int articulationPointsUtil(Person currentNode, Graph<Person, DefaultEdge> graph,
                                              Map<Person, Boolean> visited, Map<Person, Integer> discoveryTimes,
                                              Map<Person, Integer> low, Map<Person, Person> parent,
                                              Set<Person> articulationPoints, int time) {
        int children = 0;
        visited.replace(currentNode, true);
        time++;
        discoveryTimes.replace(currentNode, time);
        low.replace(currentNode, time);

        List<Person> adjacencyList = graph.edgesOf(currentNode).stream().map(edge -> {
            if (graph.getEdgeTarget(edge) == currentNode) {
                return graph.getEdgeSource(edge);
            }
            return graph.getEdgeTarget(edge);
        }).collect(Collectors.toList());

        for (Person adjacent : adjacencyList) {
            if (!visited.get(adjacent)) {
                children++;
                parent.replace(adjacent, currentNode);
                time = articulationPointsUtil(adjacent, graph, visited, discoveryTimes, low, parent, articulationPoints, time);

                low.replace(currentNode, Math.min(low.get(currentNode), low.get(adjacent)));

                if (parent.get(currentNode) == null && children > 1 ||
                        parent.get(currentNode) != null && low.get(adjacent) >= discoveryTimes.get(currentNode)) {
                    articulationPoints.add(currentNode);
                }
            }
            else if (adjacent != parent.get(currentNode)) {
                low.replace(currentNode, Math.min(low.get(currentNode), discoveryTimes.get(adjacent)));
            }
        }

        return time;
    }
}
