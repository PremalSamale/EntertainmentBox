package edu.sjsu.entertainmentbox.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
	public String customerForm(ModelMap model) {
		logger.info("****************inside CustomerController:customerform method");
		/*ModelAndView mv = new ModelAndView();
		mv.setViewName("customer.html");*/
		return "customer";
	}
	
	@RequestMapping(value="/subscribe", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView subscribe(ModelMap model,@RequestParam(value="noOfMonths", required=false) String noOfMonths, @RequestParam(value="price", required=false) String price) {
		logger.info("*******************inside CustomerController:subscribe method");
		logger.info("*********price*****" + price + "***************8");
		logger.info("***********noOfMonths********" + noOfMonths + "*********noOfMonths*************");
		String emailAddress = "premal.samale19@gmail.com";
		ModelAndView mv= new ModelAndView("subscribe");
		int price2=0;
		int noOfMonth =0;
		int cost =0;
		if(price!=null && noOfMonths!=null) {
			 price2 = Integer.parseInt(price);
			 noOfMonth = Integer.parseInt(noOfMonths);
			 cost =noOfMonth* price2;
		}else {
			 price2=10;
			 noOfMonth =1;
			cost =10;
		}
	  
		customerService.saveSubscription(emailAddress,cost,noOfMonth, SubscriptionType.SUBSCRIPTION_ONLY, null);
		
		return mv;
	}

}
