package edu.sjsu.entertainmentbox.dao;


import org.springframework.data.repository.CrudRepository;
import edu.sjsu.entertainmentbox.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
    List<User> findByEmailAddressAndPassword(String emailAddress, String password);

}

