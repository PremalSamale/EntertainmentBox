package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.model.MoviePlayLog;

import java.util.List;

public interface AdminService {

    void addMovie(Movie movie);

    void editMovie (Movie movie);

    void deleteMovie (Long movieId);

    List<Movie> searchMovies();

    List<Customer> browseCustomers();

    List<MoviePlayLog> getMoviePlayhistory(Integer customerId);

    //**For every movie, it can be counted as only one play for the same customer within 24 hours.
    List<Customer> getTopNCustomers(Integer timePeriod);

    //**For every movie, it can be counted as only one play for the same customer within 24 hours.
    Integer getNumberOfPlays(Integer timePeriod);

    List<Customer> getTopNMovies(Integer timePeriod);





}
