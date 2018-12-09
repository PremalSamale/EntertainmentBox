package edu.sjsu.entertainmentbox.controller;

import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.entertainmentbox.event.OnRegistrationCompleteEvent;
import edu.sjsu.entertainmentbox.model.AuthenticUser;
import edu.sjsu.entertainmentbox.model.VerificationToken;
import edu.sjsu.entertainmentbox.service.AuthenticUserService;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private AuthenticUserService userService;

	@Autowired
    private MessageSource messages;

	@Autowired
	ApplicationEventPublisher eventPublisher;

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView showForm(ModelMap model) {
		return new ModelAndView("signup");
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView saveForm(
			ModelMap model,
			@RequestParam(value="username", required=false) String username,
			@RequestParam(value="firstName", required=false) String firstName,
			@RequestParam(value="lastName", required=false) String lastName,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="password2", required=false) String password2,
			HttpSession session,
			WebRequest request
		) {
		userService.saveUserAndRole(username,firstName,lastName, password, false);
		AuthenticUser user = userService.getUser(username);
		String appUrl = request.getContextPath();
		eventPublisher.publishEvent(new OnRegistrationCompleteEvent
		          (user, request.getLocale(), appUrl));
		return new ModelAndView("pendingVerification");
	}

	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
	public ModelAndView confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token) {
		System.out.println("token: " + token);
		logger.info("token: " + token);
		Locale locale = request.getLocale();
		VerificationToken verificationToken = userService.getVerificationToken(token);
		if (verificationToken == null) {
			String message = messages.getMessage("auth.message.invalidToken", null, locale);
	        model.addAttribute("message", message);
	        ModelAndView mv = new ModelAndView("badUser");
	        mv.addObject("message", message);
	        return mv;
		}
		Calendar cal = Calendar.getInstance();
	    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	        String messageValue = messages.getMessage("auth.message.expired", null, locale);
	        model.addAttribute("message", messageValue);
	        ModelAndView mv = new ModelAndView("badUser");
	        return mv;
	    }

	    AuthenticUser user = verificationToken.getUser();
	    System.out.println("user email: " + user.getUsername());
	    user.setEnabled(true); 
	    userService.saveRegisteredUser(user); 
	    ModelAndView mv = new ModelAndView("success");
        return mv;
	}

/*
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(
			ModelMap model,
			@RequestParam(value="emailAddress", required=false) String emailAddress,
			@RequestParam(value="password", required=false) String password,
			HttpSession session
		) {
		return new ModelAndView("login");
	}*/

	
/*	@RequestMapping(value="/login", method=RequestMethod.POST)
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
	*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model,
			@RequestParam(value="emailAddress", required=false) String emailAddress,
			@RequestParam(value="password", required=false) String password,
			HttpSession session, String error, String logout) {
		ModelAndView mv = new ModelAndView("login");
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return mv;
	}
	

	
}
