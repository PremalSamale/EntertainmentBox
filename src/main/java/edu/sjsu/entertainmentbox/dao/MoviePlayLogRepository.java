package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.MoviePlayLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MoviePlayLogRepository extends JpaRepository<MoviePlayLog, Integer> {

    @Query("select p from MoviePlayLog p where p.movie.movieId = :movieId and p.mveStartTs > :startDate  GROUP   BY  DATE(p.mveStartTs)")
    Optional<List<MoviePlayLog>> noOfPlaysForAMovie(@Param("startDate") Date startDate, @Param("movieId") Integer movieId);
}
