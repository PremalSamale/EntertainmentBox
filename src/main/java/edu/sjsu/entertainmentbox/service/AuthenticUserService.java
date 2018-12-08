package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.model.AuthenticUser;

public interface AuthenticUserService {
	public AuthenticUser getUser(String username);
	public void saveUserAndRole(String username, String firstName, String lastName, String password, boolean enabled);
	public void createVerificationToken(AuthenticUser user, String token);
	public void confirmRegistration(AuthenticUser user);
}
