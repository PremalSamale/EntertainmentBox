package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.MoviePlayLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviePlayLogRepository extends JpaRepository<MoviePlayLog, Integer> {
}
