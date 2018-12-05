package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {


}
