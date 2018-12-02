package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.model.MoviePlayLog;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    @Override
    public void addMovie(Movie movie) {

    }

    @Override
    public void editMovie(Integer movieId) {

    }

    @Override
    public void deleteMovie(Integer movieId) {

    }

    @Override
    public List<Movie> searchMovies() {
        return null;
    }

    @Override
    public List<Customer> browseCustomers() {
        return null;
    }

    @Override
    public List<MoviePlayLog> getMoviePlayhistory(Integer customerId) {
        return null;
    }

    //**For every movie, it can be counted as only one play for the same customer within 24 hours.
    @Override
    public List<Customer> getTopNCustomers(Integer timePeriod) {
        return null;
    }

    //**For every movie, it can be counted as only one play for the same customer within 24 hours.
    @Override
    public Integer getNumberOfPlays(Integer timePeriod) {
        return null;
    }

    @Override
    public List<Customer> getTopNMovies(Integer timePeriod) {
        return null;
    }
}
