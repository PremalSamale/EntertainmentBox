package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.User;

public interface UserDao {
	public void saveUser(User user);
	public User getUser(String emailAddress);
}
