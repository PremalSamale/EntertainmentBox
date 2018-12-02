package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
