package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.AuthenticUser;

public interface AuthenticUserDao {
	
	AuthenticUser findByUserName(String username);

}
