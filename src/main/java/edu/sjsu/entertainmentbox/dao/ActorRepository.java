package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

}
