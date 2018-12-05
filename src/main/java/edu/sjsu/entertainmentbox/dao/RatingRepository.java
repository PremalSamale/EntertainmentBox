package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.component.MoviesByRatingComponent;
import edu.sjsu.entertainmentbox.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query("SELECT" +
            " new edu.sjsu.entertainmentbox.component.MoviesByRatingComponent(v.movie, AVG(v))" +
            " FROM" +
            " Rating v INNER JOIN v.movie m" +
            " WHERE" +
            " MONTH(v.ratingTS) > :prevMonth" +
            " GROUP BY" +
            " m.movieId" +
            " ORDER BY" +
            " AVG(v.rating) desc")
    List<MoviesByRatingComponent> findByRating(@Param("prevMonth") Integer prevMonth);
}
