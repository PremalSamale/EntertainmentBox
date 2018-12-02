package edu.sjsu.entertainmentbox.dao;


import edu.sjsu.entertainmentbox.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByEmailAddressAndPassword(String emailAddress, String password);
}

