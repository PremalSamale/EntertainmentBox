package edu.sjsu.entertainmentbox.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rating {

    private Integer ratingId;
    private Integer customerId;
    private Integer movieId;
    private Integer rating;
    private Date ratingTS;

    public Rating() {
    }

    public Rating(Integer customerId, Integer movieId, Integer rating, Date ratingTS) {
        this.customerId = customerId;
        this.movieId = movieId;
        this.rating = rating;
        this.ratingTS = ratingTS;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RATING_ID", nullable = false, unique = true)
    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    @Column(name = "CUST_ID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "MOVIE_ID")
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Column(name = "RATING")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "RATING_TS")
    public Date getRatingTS() {
        return ratingTS;
    }

    public void setRatingTS(Date ratingTS) {
        this.ratingTS = ratingTS;
    }
}