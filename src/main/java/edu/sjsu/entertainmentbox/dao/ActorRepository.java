package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
