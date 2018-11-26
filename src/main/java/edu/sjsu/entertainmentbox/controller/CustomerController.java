package edu.sjsu.entertainmentbox.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.entertainmentbox.model.SubscriptionType;
import edu.sjsu.entertainmentbox.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer")
	public ModelAndView customerForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer.jsp");
		return mv;
	}
	
	@RequestMapping(value="/subscribe", method=RequestMethod.POST)
	public ModelAndView subscribe(HttpServletRequest request) {
		String emailAddress = "premal.samale19@gmail.com";
		int price = Integer.parseInt(request.getParameter("price"));
		int noOfMonths = Integer.parseInt(request.getParameter("noOfMonths"));
		price = price * noOfMonths;

		customerService.saveSubscription(emailAddress, price, noOfMonths, SubscriptionType.SUBSCRIPTION_ONLY, null);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer.jsp");
		return mv;
	}

}
