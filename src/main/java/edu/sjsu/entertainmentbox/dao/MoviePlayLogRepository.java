package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.MoviePlayLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePlayLogRepository extends JpaRepository<MoviePlayLog, Long> {
}
