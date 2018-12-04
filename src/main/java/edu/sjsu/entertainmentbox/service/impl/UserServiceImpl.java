package edu.sjsu.entertainmentbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.entertainmentbox.dao.UserDao;
import edu.sjsu.entertainmentbox.model.User;
import edu.sjsu.entertainmentbox.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

/*	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}*/



	@Transactional
	public User getUser(String emailAddress) {
		return userDao.getUser(emailAddress);
	}



	@Transactional
	public void saveUser(String emailAddress, String firstName, String lastName, String password) {
		// TODO Auto-generated method stub
		User user= new User();
		user.setEmailAddress(emailAddress);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		userDao.saveUser(user);
	}

/*	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}*/

}
