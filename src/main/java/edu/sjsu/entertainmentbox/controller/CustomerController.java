package edu.sjsu.entertainmentbox.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.entertainmentbox.EntertainmentBoxApplication;
import edu.sjsu.entertainmentbox.model.SubscriptionType;
import edu.sjsu.entertainmentbox.service.CustomerService;

@Controller
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(EntertainmentBoxApplication.class);
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public String customerForm() {
		logger.info("****************inside CustomerController:customerform method");
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("customer.html");*/
		return "customer";
	}
	
	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
	public String subscribe(HttpServletRequest request) {
		logger.info("*******************inside CustomerController:subscribe method");
		String emailAddress = "premal.samale19@gmail.com";
		int price = Integer.parseInt(request.getParameter("price"));
		int noOfMonths = Integer.parseInt(request.getParameter("noOfMonths"));
		price = price * noOfMonths;

		customerService.saveSubscription(emailAddress, price, noOfMonths, SubscriptionType.SUBSCRIPTION_ONLY, null);
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("customer.html");*/
		return "customer";
	}

}
