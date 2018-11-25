package edu.sjsu.entertainmentbox.dao;


import edu.sjsu.entertainmentbox.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
