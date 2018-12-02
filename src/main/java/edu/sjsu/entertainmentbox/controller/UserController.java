package edu.sjsu.entertainmentbox.controller;

import java.net.URI;
import java.security.Principal;

import edu.sjsu.entertainmentbox.model.User;
import edu.sjsu.entertainmentbox.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.*;

import javax.xml.ws.Response;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    public UserService userService;


    @PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session) throws JSONException
    {
        JSONObject jsonObject = new JSONObject(user);
        session.setAttribute("name",jsonObject.getString("username"));
        return new ResponseEntity(userService.login(jsonObject.getString("username"),jsonObject.getString("password")),HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) throws JSONException{
        System.out.println(session.getAttribute("name"));
        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }

//    @PostMapping(path="/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> signup(@RequestBody String user, HttpSession session) throws JSONException
//    {
//        JSONObject jsonObject = new JSONObject(user);
//        return new ResponseEntity(userService.addUser(jsonObject.getString("username"),jsonObject.getString("password"));,HttpStatus.OK);
//    }

    @GetMapping("users/{username}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<User> getUser(@PathVariable String username) throws Exception{
        User user = userService.getUser(username);
        return new ResponseEntity<User>(user, HttpStatus.FOUND);
    }

    @DeleteMapping("/users/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createStudent(@RequestBody User user) {
        User savedUser = userService.addUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(savedUser.getEmailAddress()).toUri();

        System.out.println(location);

        return ResponseEntity.created(location).build();

    }

}
