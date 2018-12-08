package edu.sjsu.entertainmentbox.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.entertainmentbox.dao.AuthenticUserDao;
import edu.sjsu.entertainmentbox.model.AuthenticUser;
import edu.sjsu.entertainmentbox.model.UserRole;
import edu.sjsu.entertainmentbox.service.AuthenticUserService;

@Service
public class AuthenticUserServiceImpl implements AuthenticUserService {
	@Autowired
	private AuthenticUserDao userDao;

	@Transactional
	public AuthenticUser getUser(String username) {
		return userDao.getUser(username);
	}

	@Transactional
	public void saveUserAndRole(String username, String firstName, String lastName, String password, boolean enabled) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		AuthenticUser user = new AuthenticUser(username, hashedPassword, firstName, lastName, enabled);

		UserRole userRole = new UserRole();
		if (username.endsWith("sjsu.edu")) {
			userRole.setRole("ROLE_ADMIN");
			userRole.setUser(user);
		} else {
			userRole.setRole("ROLE_USER");
			userRole.setUser(user);
		}
		
		userDao.saveUserAndRole(userRole, user);
	}

}
