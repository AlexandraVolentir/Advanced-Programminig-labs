package models;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.io.Serializable;

@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select e from City e order by e.id"),
        @NamedQuery(name = "City.findById",
                query = "select e from City e where e.id = :id"),
        @NamedQuery(name = "City.findByName",
                query = "select e from City e where e.name = :name"),
        })

/**
 * entity class for City
 */
public class City extends AbstractEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "latitude")
    private Double latitude;

    @Basic
    @Column(name = "longitude")
    private Double longitude;

    @Basic
    @Column(name = "country")
    private String country;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    /**
     * getter for the city name
     * @return the city name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * setter for the city name
     * @param name the city name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
