package com.example.netflix.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "title")
public class Title {
    @NotNull
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String rating;

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", directorList=" + directorList +
                ", actorList=" + actorList +
                ", categoryList=" + categoryList +
                ", name='" + name + '\'' +
                ", date_added='" + date_added + '\'' +
                ", num_ratings=" + num_ratings +
                ", user_rating=" + user_rating +
                ", release_year='" + release_year + '\'' +
                '}';
    }

    public int getNum_ratings() {
        return num_ratings;
    }

    public void setNum_ratings(int num_ratings) {
        this.num_ratings = num_ratings;
    }

    public float getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(float user_rating) {
        this.user_rating = user_rating;
    }

    private String duration;

    private String description;
    @ManyToMany(mappedBy = "titleList")
    private List<Director> directorList;

    @ManyToMany(mappedBy = "titleList")
    private List<Actor> actorList;
    @ManyToMany(mappedBy = "titleList")
    private List<Category> categoryList;
    private String name;

    private String date_added;
    @Min(0)
    @Max(10)
    private int num_ratings;

    @Min(0)
    private float user_rating;

    private String release_year;

    public Title(Long id, String title, String date_added, String release_year, String rating, String duration, String description, List<Director> directorList, List<Actor> actorList, List<Category> categoryList) {
        this.id = id;
        this.name = title;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
        this.directorList = directorList;
        this.actorList = actorList;
        this.categoryList = categoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
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






    public Title() {
    }

    public Title(Long id, String name) {
        this.id = id;
        this.name = name;
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


}
