package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.AuthenticUser;
import edu.sjsu.entertainmentbox.model.UserRole;

public interface AuthenticUserDao {
	public AuthenticUser getUser(String username);
	public void saveUser(AuthenticUser user);
	public void saveUserAndRole(UserRole userRole, AuthenticUser user);
}
