package com.example.netflix.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Director {

    @NotNull
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;

    @JoinTable(
            name = "rel_director_title",
            joinColumns = @JoinColumn(name = "director", nullable = false),
            inverseJoinColumns = @JoinColumn(name="title", nullable = false)
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
