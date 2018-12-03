package edu.sjsu.entertainmentbox.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.entertainmentbox.model.User;
import edu.sjsu.entertainmentbox.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
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
			//BindingResult br,
			HttpSession session
		) {
		User user = new User(emailAddress, firstName, lastName, password);
		userService.saveUser(user);
		return new ModelAndView("success");
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(
			ModelMap model,
			@RequestParam(value="emailAddress", required=false) String emailAddress,
			@RequestParam(value="password", required=false) String password,
			BindingResult br,
			HttpSession session
		) {
		User user = userService.getUser(emailAddress);
		session.setAttribute("user", user);
		if (user.getPassword().equals(password)) {
			return new ModelAndView("customer");
		} else {
			return null;
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginPost(
			ModelMap model,
			@RequestParam(value="emailAddress", required=false) String emailAddress,
			@RequestParam(value="password", required=false) String password,
			BindingResult br,
			HttpSession session
		) {
		User user = userService.getUser(emailAddress);
		session.setAttribute("user", user);
		if (user.getPassword().equals(password)) {
			return new ModelAndView("customer");
		} else {
			return null;
		}
	}
}
