package com.example.netflix.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {

    @NotNull
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @NotNull
    private String name;

    @JoinTable(
            name = "title_director",
            joinColumns = @JoinColumn(name = "director_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="title_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Title> titleList;

    public Director() {
    }

    public Director(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
