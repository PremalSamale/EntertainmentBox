package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.model.User;

public interface UserService {
	public void saveUser(User user);
	public User getUser(String emailAddress);
}
