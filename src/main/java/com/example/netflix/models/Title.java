package com.example.netflix.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "title")
public class Title {
    @NotNull
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String title;

    private String country;

    private String date_added;

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", date_added='" + date_added + '\'' +
                ", release_year='" + release_year + '\'' +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", directorList=" + directorList +
                ", actorList=" + actorList +
                ", categoryList=" + categoryList +
                '}';
    }

    private String release_year;

    public Title(Long id, String title, String country, String date_added, String release_year, String rating, String duration, String description, List<Director> directorList, List<Actor> actorList, List<Category> categoryList) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
        this.directorList = directorList;
        this.actorList = actorList;
        this.categoryList = categoryList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    private String rating;

    private String duration;

    private String description;
    @ManyToMany(mappedBy = "director")
    private List<Director> directorList;

    @ManyToMany(mappedBy = "title")
    private List<Actor> actorList;

    @ManyToMany(mappedBy = "listed_in")
    private List<Category> categoryList;


    public Title() {
    }

    public Title(Long id, String name) {
        this.id = id;
        this.title = name;
    }

    public void addDirector(Director director){
        if(this.directorList == null){
            this.directorList = new ArrayList<>();
        }

        this.directorList.add(director);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }
}
