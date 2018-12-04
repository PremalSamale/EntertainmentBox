package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.component.MoviePlayLogComponent;
import edu.sjsu.entertainmentbox.dao.CustomerRepository;
import edu.sjsu.entertainmentbox.dao.MoviePlayLogRepository;
import edu.sjsu.entertainmentbox.dao.MovieRepository;
import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.model.MoviePlayLog;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    MoviePlayLogRepository moviePlayLogRepository;


    @Override
    public void addMovie(Movie movie) {


    }

    @Override
    public void editMovie(Movie movie) {

        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Integer movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public List<Movie> searchMovies() {

        return movieRepository.findAll();
    }

    @Override
    public List<Customer> browseCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public List<MoviePlayLogComponent> getMoviePlayhistory(Integer customerId) {
        /*List<MoviePlayLog> moviePlayLogs = customerRepository.findByCustomerId(customerId);
        List<MoviePlayLogComponent> moviePlayLogComponents = new ArrayList<>();
        for (MoviePlayLog moviePlayLog: moviePlayLogs) {
            Optional<Movie> movie = movieRepository.findById(moviePlayLog.getMovie().getMovieId());
            if(movie.isPresent())
            {
                moviePlayLogComponents.add(new MoviePlayLogComponent(movie.get(), moviePlayLog));
            }
        }
            return moviePlayLogComponents;*/
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
