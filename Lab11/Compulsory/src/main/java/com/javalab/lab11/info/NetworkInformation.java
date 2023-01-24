package com.javalab.lab11.info;

import com.javalab.lab11.models.Person;
import org.jgrapht.Graph;
import org.jgrapht.graph.*;

import java.util.List;

/**
 * Class that generates a graph using Persons as nodes and friendships between them as edges
 */
public class NetworkInformation {
    public static Graph<Person, DefaultEdge> getUndirectedGraph(List<Person> persons) {
        Graph<Person, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);

        persons.forEach(graph::addVertex);

        for (Person person : persons) {
            for (Person friend : person.getFriends()) {
                graph.addEdge(person, friend);
            }
        }
        return graph;
    }
}
