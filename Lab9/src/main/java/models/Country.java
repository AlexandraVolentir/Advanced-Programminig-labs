package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "countries")
@NamedQueries({
        @NamedQuery(name = "Country.findAll",
                query = "select e from Country e order by e.id"),
        @NamedQuery(name = "Country.findById",
                query = "select e from Country e where e.id = :id"),
        @NamedQuery(name = "Country.findByName",
                query = "select e from Country e where e.name = :name"),
})

/**
 * entity class for country
 */
public class Country extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "code")
    private String code;

    @Basic
    @Column(name = "continent")
    private String continent;

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @OneToMany
    private List<City> oneToMany;

    public List<City> getOneToMany() {
        return oneToMany;
    }

    public void setOneToMany(List<City> oneToMany) {
        this.oneToMany = oneToMany;
    }
}