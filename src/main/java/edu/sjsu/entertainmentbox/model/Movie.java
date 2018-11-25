package edu.sjsu.entertainmentbox.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    private Integer movieId;
    private String title;
    private String genre;
    private Integer year;
    private String studio;
    private String synopsis;
    private String Image;
    private String Movie;
    private Set<Actor> actors = new HashSet<Actor>(0);
    private Integer directorId;
    private String country;
    private Integer rating;
    private String movieType;
    private Integer price;

    public Movie() {
    }

    public Movie(String title, String genre, Integer year, String studio, String synopsis, String image, String movie, Set<Actor> actors, Integer directorId, String country, Integer rating, String movieType, Integer price) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.studio = studio;
        this.synopsis = synopsis;
        Image = image;
        Movie = movie;
        this.actors = actors;
        this.directorId = directorId;
        this.country = country;
        this.rating = rating;
        this.movieType = movieType;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOVIE_ID", nullable = false, unique = true)
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "GENRE")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "YEAR")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Column(name = "STUDIO")
    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Column(name = "SYNOPSIS")
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Column(name = "IMAGE")
    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Column(name = "MOVIE")
    public String getMovie() {
        return Movie;
    }

    public void setMovie(String movie) {
        Movie = movie;
    }


    @Column(name = "DIRECTOR_ID")
    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "RATING")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Column(name = "MOVIE_TYPE")
    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Actor", joinColumns = {
            @JoinColumn(name = "MOVIE_ID", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "ACTOR_ID", nullable = false, updatable = false)})
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}