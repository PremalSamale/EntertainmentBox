package edu.sjsu.entertainmentbox.component;

import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.model.MoviePlayLog;
import org.springframework.stereotype.Component;

@Component
public class MoviePlayLogComponent {

    private Movie movie;
    private MoviePlayLog moviePlayLog;


    public MoviePlayLogComponent() {
    }

    public MoviePlayLogComponent(Movie movie, MoviePlayLog moviePlayLog) {
        this.movie = movie;
        this.moviePlayLog = moviePlayLog;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MoviePlayLog getMoviePlayLog() {
        return moviePlayLog;
    }

    public void setMoviePlayLog(MoviePlayLog moviePlayLog) {
        this.moviePlayLog = moviePlayLog;
    }
}
