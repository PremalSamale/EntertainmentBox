package edu.sjsu.entertainmentbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.entertainmentbox.dao.AuthenticUserDao;
import edu.sjsu.entertainmentbox.dao.VerificationTokenRepository;
import edu.sjsu.entertainmentbox.model.AuthenticUser;
import edu.sjsu.entertainmentbox.model.UserRole;
import edu.sjsu.entertainmentbox.model.VerificationToken;
import edu.sjsu.entertainmentbox.service.AuthenticUserService;

@Service
public class AuthenticUserServiceImpl implements AuthenticUserService {
	@Autowired
	private AuthenticUserDao userDao;

	@Autowired
    private VerificationTokenRepository tokenRepository;

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

	@Override
	public void createVerificationToken(AuthenticUser user, String token) {
		VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
	}

	@Override
	public void confirmRegistration(AuthenticUser user) {
		System.out.println("user: " + user.getUsername());
	}

}
