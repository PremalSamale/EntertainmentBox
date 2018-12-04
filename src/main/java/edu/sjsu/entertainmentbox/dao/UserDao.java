package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.User;

public interface UserDao {	
	public User getUser(String emailAddress);
	public void saveUser(User user);
}
