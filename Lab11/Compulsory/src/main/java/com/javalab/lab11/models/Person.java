package com.javalab.lab11.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entity class from database
 */
@Entity
@Table(name = "PERSONS")
public class Person {
    @Id
    @SequenceGenerator(name = "personsSequence", sequenceName = "S_PERSONS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personsSequence")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Basic
    @Column(name = "NAME", nullable = false, length = 64)
    private String name;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "FRIENDS", joinColumns = @JoinColumn(name = "ID_FRIEND1", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "ID_FRIEND2", referencedColumnName = "ID", nullable = false))
    @JsonIgnoreProperties({"friends", "friendOf"})
    private Set<Person> friends = new HashSet<>();

    @ManyToMany(mappedBy = "friends", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"friends", "friendOf"})
    private Set<Person> friendOf = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person account = (Person) o;
        return Objects.equals(id, account.id) && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public Set<Person> getFriendOf() {
        return friendOf;
    }

    @Override
    public String toString() {
        return name;
    }
}
