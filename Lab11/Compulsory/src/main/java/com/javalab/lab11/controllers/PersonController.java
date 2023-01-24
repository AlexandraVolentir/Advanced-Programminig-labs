package com.javalab.lab11.controllers;

import com.javalab.lab11.exception.AlgorithmException;
import com.javalab.lab11.models.Person;
import com.javalab.lab11.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("api/v1/lab11")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * @return the list of the persons, via HTTP GET request.
     */
    @GetMapping
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> persons = personService.findAll();

        return new ResponseEntity<>(persons, new HttpHeaders(), HttpStatus.OK);
    }
    /**
     * @return a person via HTTP GET by id request.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    /**
     * adding a new person, via a HTTP POST request
     * @param person name of the person to be created
     * @return 201 Created success or 500 client provided an invalid id
     */
    @PostMapping(value = "/create-person", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.save(person);
        if (createdPerson == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(createdPerson, new HttpHeaders(), HttpStatus.CREATED);
    }

    /**
     * modifying the name of a person, via a HTTP PUT request
     * @param id
     * @param person name
     * @return 200 request has succeeded
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return new ResponseEntity<>(personService.update(id, person), new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * deleting a person, via a HTTP DELETE request.
     * @param id
     * @return 200 request has succeeded
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return new ResponseEntity<>(id, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Create REST services for reading relationships
     * @param id of the person we want to see relationships
     * @return 404 not found or 200
     */
    @GetMapping("/{id}/friends")
    public ResponseEntity<Set<Person>> getFriends(@PathVariable Long id) {
        Person person = personService.findById(id).orElseThrow(ResourceNotFoundException::new);
        return new ResponseEntity<>(person.getFriends(), new HttpHeaders(), HttpStatus.OK);
    }
    /**
     * Create REST services for inserting relationships
     * @param id person that will have a new friend
     * @return 404 not found or 200
     */
    @PostMapping(value = "/{id}/friends", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> addFriend(@PathVariable Long id, @RequestBody Long idFriend) {
        Person person = personService.findById(id).orElseThrow(ResourceNotFoundException::new);
        Person friend = personService.findById(idFriend).orElseThrow(ResourceNotFoundException::new);
        person.getFriends().add(friend);
        person = personService.save(person);
        return new ResponseEntity<>(person, new HttpHeaders(), HttpStatus.CREATED);
    }

    /**
     * determine the first k most popular persons in the network
     * @param k positive integer
     * @return 200
     */
    @GetMapping(value = "/most-popular")
    public ResponseEntity<List<Person>> getMostPopular(@RequestParam int k) {
        if (k < 0) {
            throw new AlgorithmException("k can't be a negative number!");
        }

        return new ResponseEntity<>(personService.kMostPopular(k), new HttpHeaders(), HttpStatus.OK);
    }
    /**
     * determines in linear time all persons who are so important to the social network such that, if one of them were eliminated,
     * the network would become disconnected
     * @return list of cut vertices where nodes are persons
     */
    @GetMapping("/important")
    public ResponseEntity<Set<Person>> getImportant() {
        Set<Person> returnedSet = personService.findImportantPersons();

        if (returnedSet.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(returnedSet, new HttpHeaders(), HttpStatus.OK);
    }
}
