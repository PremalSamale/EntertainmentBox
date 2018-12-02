<<<<<<< HEAD
package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
=======
package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

}
>>>>>>> 4e1e105485b34bd99377ef740b417fb1f228d774
