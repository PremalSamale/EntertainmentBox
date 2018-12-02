package edu.sjsu.entertainmentbox.dao;


<<<<<<< HEAD
import edu.sjsu.entertainmentbox.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
=======
>>>>>>> 4e1e105485b34bd99377ef740b417fb1f228d774
import org.springframework.data.repository.CrudRepository;
import edu.sjsu.entertainmentbox.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;

<<<<<<< HEAD
public interface UserRepository extends JpaRepository<User, Long> {

=======
@Repository
public interface UserRepository extends CrudRepository<User, String>{
    List<User> findByEmailAddressAndPassword(String emailAddress, String password);
>>>>>>> 4e1e105485b34bd99377ef740b417fb1f228d774

}

