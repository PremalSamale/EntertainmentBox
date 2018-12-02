package edu.sjsu.entertainmentbox.controller;

import edu.sjsu.entertainmentbox.model.Actor;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.service.MovieService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;


@RestController
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies/{movieId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Movie> getMovie(@PathVariable Integer movieId) throws Exception{
        Movie movie = movieService.getMovie(movieId);
        return new ResponseEntity<Movie>(movie, HttpStatus.FOUND);
    }


    @GetMapping("/movies/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Movie> getUser() throws Exception{
       List<Movie> movies = movieService.findAllMovies();
        return movies;
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteUser(@PathVariable Integer movieId) {
        movieService.deleteMovie(movieId);
    }

    @PostMapping(path = "/movies" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createMovie(@RequestBody String movie) throws JSONException {
        JSONObject jsonObject = new JSONObject(movie);
        JSONArray arrJson = jsonObject.getJSONArray("actors");
        String[] arr = new String[arrJson.length()];
        Set<Actor> actorSet = new HashSet<>();
        for (int i=0; i<arrJson.length(); i++){
            arr[i] = arrJson.getString(i);
            Actor actor = new Actor(arr[i], i) ;
            actorSet.add(actor);
        }
        String title = jsonObject.getString("title");
        String studio = jsonObject.getString("studio");
        String synopsis =  jsonObject.getString("synopsis");
        String image = jsonObject.getString("image");
        String genre = jsonObject.getString("genre");
        String director = jsonObject.getString("director");
        String country = jsonObject.getString("country");
        String movieType = jsonObject.getString("movieType");
        Integer year = jsonObject.getInt("year");
        Integer rating = jsonObject.getInt("rating");
        Integer price = jsonObject.getInt("price");

        Movie movie = new Movie(title, genre, year, studio, synopsis, image, actorSet, director, country, rating, movieType, price);
////        Movie movie = new Movie();
////        public Movie(String title, String genre, Integer year, String studio, String synopsis, String image, String movie, Set<Actor> actors, Integer directorId, String country, Integer rating, String movieType, Integer price);
//        Movie savedUser = movieService.addMovie();
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{movieid}")
//                .buildAndExpand(savedUser.getMovieId()).toUri();
//
//        System.out.println(location);
//
//        return ResponseEntity.created(location).build();

    }

//    @PostMapping("/movies")
//    public ResponseEntity<Object> createNewMovie(@RequestBody Movie movie){
//        Movie savedUser = movieService.addMovie(movie);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{movieid}")
//                .buildAndExpand(savedUser.getMovieId()).toUri();
//
//        System.out.println(location);
//
//        return ResponseEntity.created(location).build();
//    }
//



    @PutMapping("/movies/{movieId}")
    public ResponseEntity<Object> updateMovie(@RequestBody Movie movie, @PathVariable Integer movieId) {
        Movie savedUser = movieService.updateMovie(movieId, movie);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{movieid}")
                .buildAndExpand(savedUser.getMovieId()).toUri();

        System.out.println(location);

        return ResponseEntity.noContent().build();


    }

}
