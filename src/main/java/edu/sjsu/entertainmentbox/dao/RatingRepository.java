package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
