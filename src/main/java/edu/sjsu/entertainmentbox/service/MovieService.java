package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.dao.MovieRepository;
import edu.sjsu.entertainmentbox.dao.ActorRepository;
import edu.sjsu.entertainmentbox.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.*;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;


    public Movie addMovie(Movie movie){
        Movie savedMovie = movieRepository.save(movie);
//        Set<Actor>  actors = movie.getActors();
//
//        Iterator<Actor> it = actors.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next().getName());
//        }
        return savedMovie;
    }

    public Movie updateMovie(Integer movie_id, Movie movie){
        Optional<Movie> movieOptional = movieRepository.findById(movie_id);
        if(!movieOptional.isPresent()){
            System.out.println("movie Not Found-"+movie);
        }

        movie.(movie_id);
        return movieRepository.save(movie);
    }


    public Movie getMovie(Integer movie_id){
        Optional<Movie> movie = movieRepository.findById(movie_id);


        if(!movie.isPresent()){
            System.out.println("movie Not Found-"+movie);
        }

        return movie.get();
    }

    public void deleteMovie(Integer movieId){
        movieRepository.deleteById(movieId);
    }

    public List<Movie> findAllMovies(){
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

}
