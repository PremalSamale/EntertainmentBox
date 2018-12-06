package edu.sjsu.entertainmentbox.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import edu.sjsu.entertainmentbox.EntertainmentBoxApplication;
import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.User;
import edu.sjsu.entertainmentbox.service.CustomerService;
import edu.sjsu.entertainmentbox.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;


	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView showForm(ModelMap model) {
		return new ModelAndView("signup");
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView saveForm(
			ModelMap model,
			@RequestParam(value="emailAddress", required=false) String emailAddress,
			@RequestParam(value="firstName", required=false) String firstName,
			@RequestParam(value="lastName", required=false) String lastName,
			@RequestParam(value="password", required=false) String password,
			HttpSession session
		) {
		//User user = new User(emailAddress, firstName, lastName, password);
		logger.info("password is " + password);
		userService.saveUser(emailAddress,firstName,lastName, password);
		return new ModelAndView("success");
	}
	
/*	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView saveForm(
			ModelMap model,
			@ModelAttribute("usersignup") User user,
			HttpSession session
		) {
		userService.saveUser(user);
		return new ModelAndView("success");
	}*/
	


	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(
			ModelMap model,
			@RequestParam(value="emailAddress", required=false) String emailAddress,
			@RequestParam(value="password", required=false) String password,
			HttpSession session
		) {
		return new ModelAndView("login");
	}
/*
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(
			ModelMap model,
			@RequestParam(value="emailAddress", required=false) String emailAddress,
			@RequestParam(value="password", required=false) String password,
			HttpSession session
		) {
		logger.info("***************inside UserController LoginPost()**********");
		User user = userService.getUser(emailAddress);
		logger.info("***************user name****"+user.getFirstName()+"**********");
		session.setAttribute("user", user);
		if (user.getPassword().equals(password)) {
			
			return new ModelAndView("customer");
		} else {
			return null;
		}
	}*/
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(
			ModelMap model,
			@ModelAttribute("userlogin") User currentUser,
			HttpSession session
		) {
		logger.info("***************inside UserController LoginPost()**********");
		User user = userService.getUser(currentUser.getEmailAddress());
	
		logger.info("***************user password****"+	user.getPassword()+"**********");	
		logger.info("***************user name****"+user.getFirstName()+"**********");
		logger.info("***************user lastname****"+	user.getLastName()+"**********");
		session.setAttribute("user", currentUser);
		if (user.getPassword().equals(currentUser.getPassword())) {		
				ModelAndView mv = new ModelAndView("customer");
				mv.addObject("emailAddress", currentUser.getEmailAddress());
				return mv;
		} else {
			return null;
		}
	}
	
	

	
}
