package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.dao.UserRepository;
import edu.sjsu.entertainmentbox.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User addUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public  void deleteUser( String username){
        userRepository.deleteById(username);
    }

    public User getUser(String username){
        Optional<User> user = userRepository.findById(username);

        if(!user.isPresent()){
            System.out.println("username Not Found-"+username);
        }

        return user.get();
    }


    public List<User> login(String emailAddress, String password) {
        return userRepository.findByEmailAddressAndPassword(emailAddress, password);
    }

}
