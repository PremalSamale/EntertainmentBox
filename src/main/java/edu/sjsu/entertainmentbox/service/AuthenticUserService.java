package edu.sjsu.entertainmentbox.service;

import java.util.Set;

import edu.sjsu.entertainmentbox.model.AuthenticUser;
import edu.sjsu.entertainmentbox.model.UserRole;

public interface AuthenticUserService {
	public AuthenticUser getUser(String username);
	public void saveUserAndRole(String username, String firstName, String lastName, String password, boolean enabled);
}
