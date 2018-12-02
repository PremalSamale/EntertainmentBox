<<<<<<< HEAD
package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
=======
package edu.sjsu.entertainmentbox.dao;


import edu.sjsu.entertainmentbox.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {



}
>>>>>>> 4e1e105485b34bd99377ef740b417fb1f228d774
