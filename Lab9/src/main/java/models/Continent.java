package models;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "continents")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from Continent e order by e.id"),
        @NamedQuery(name = "Continent.findById",
                query = "select e from Continent e where e.id = :id"),
        @NamedQuery(name = "Continent.findByName",
                query = "select e from Continent e where e.name = :name"),
})

/**
 * entity class for continent
 */
public class Continent extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Continent(String name) {
        this.name = name;
    }

    public Continent() {

    }

    /**
     * getter for the continent id
     * @return the continent id
     */
    public Integer getId() {
        return id;
    }

    /**
     * getter for the continent name
     * @return continent name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the continent name
     * @param name continent name
     */
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    private List<Country> oneToMany;

    public List<Country> getOneToMany() {
        return oneToMany;
    }

    /**
     * set the one to many relationship
     * @param oneToMany list of countries
     */
    public void setOneToMany(List<Country> oneToMany) {
        this.oneToMany = oneToMany;
    }
}










