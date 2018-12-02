package edu.sjsu.entertainmentbox.dao;


import edu.sjsu.entertainmentbox.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
