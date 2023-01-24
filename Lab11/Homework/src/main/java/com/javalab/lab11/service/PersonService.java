package com.javalab.lab11.service;

import com.javalab.lab11.algorithm.Algorithm;
import com.javalab.lab11.info.NetworkInformation;
import com.javalab.lab11.models.Person;
import com.javalab.lab11.repository.PersonRepository;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class that holds the logic
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    /**
     *
     * @return a list with all persons that exists in dataBase
     */
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public void delete(Person person) {
        if (!personRepository.existsById(person.getId())) {
            throw new ResourceNotFoundException();
        }
        personRepository.delete(person);
    }

    /**
     * adds a new person
     * @param person
     * @return
     */
    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        personRepository.delete(person);
    }

    public Person update(Long id, Person newPerson) {
        Person updatePerson = personRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        updatePerson.setName(newPerson.getName());
        return personRepository.save(updatePerson);
    }

    /**
     * determine the first k most popular persons in the network
     * @param k positive integer
     * @return 200
     */
    public List<Person> kMostPopular(int k) {
        List<Person> allPersons = findAll();

        k = Integer.min(k, allPersons.size());

        allPersons.sort((Person p1, Person p2) -> Integer.compare(p2.getFriendOf().size(), p1.getFriendOf().size()));

        return IntStream.range(0, k).mapToObj(allPersons::get).collect(Collectors.toList());
    }

    /**
     * determines in linear time all persons who are so important to the social network such that, if one of them were eliminated,
     * the network would become disconnected
     * @return list of cut vertices where nodes are persons
     */
    public Set<Person> findImportantPersons() {
        List<Person> allPersons = findAll();
        Graph<Person, DefaultEdge> graph = NetworkInformation.getUndirectedGraph(allPersons);

        return Algorithm.getArticulationPoints(graph);
    }
}
