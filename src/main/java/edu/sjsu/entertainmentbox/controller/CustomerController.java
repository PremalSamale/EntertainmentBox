package edu.sjsu.entertainmentbox.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.sjsu.entertainmentbox.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.entertainmentbox.EntertainmentBoxApplication;
import edu.sjsu.entertainmentbox.service.CustomerService;

@Controller
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(EntertainmentBoxApplication.class);
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/user/subscribe", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView subscribe(ModelMap model,@RequestParam(value="emailaddress", required=false) String emailAddress,@RequestParam(value="noOfMonths", required=false) String noOfMonths, @RequestParam(value="price", required=false) String price) throws ParseException {
		logger.info("*******************inside CustomerController:subscribe method");
		logger.info("*********price*****" + price + "***************8");
		logger.info("***********noOfMonths********" + noOfMonths + "*********noOfMonths*************");
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

	@RequestMapping(value="/user/searchMovie", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView searchMovie(ModelMap model,@RequestParam(value="searchText", required=false) String searchText, HttpServletRequest request) {
		ModelAndView mv= new ModelAndView("customer");
		List<Movie> movies = customerService.searchMovie(searchText);
		String emailAddress = request.getUserPrincipal().getName();
		boolean isCustomer=checkCustomer(emailAddress);
		List<MovieInformation> movieInfo= new ArrayList <MovieInformation>();
		for (Movie m:movies) {
			String title=m.getTitle();
			String link=m.getMovieurl();
			String disabled="";
			logger.info("************movie availaibility******* "+m.getAvailability()+"*******************************");
			if(!isCustomer && m.getAvailability()==MovieAvailability.PAID) {
				link="";
			}
			MovieInformation mInfo=new MovieInformation(title,link,disabled);
			movieInfo.add(mInfo);
		}
		logger.info("***************************************************");
		logger.info(Arrays.toString(movies.toArray()));
		logger.info("***************************************************");
	//	mv.addObject("movieList", movies);
		mv.addObject("movieInformationList", movieInfo);
		return mv;
	}
	
	
	public boolean checkCustomer(String emailAddress) {
		logger.info("*********************CheckCustomer"+emailAddress+"******************************");

		if(customerService.getCustomer(emailAddress)!=null) {
			return true;
		}else {
			return false;
		}	
 
	}

	@ResponseBody
	@RequestMapping(value="/eb/user/subscribe", method= {RequestMethod.POST,RequestMethod.GET})
	public ResponseEntity<String> ebSubscribe(
			@RequestParam(value="username", required=false) String username,
			@RequestParam(value="noOfMonths", required=false) String noOfMonths,
			@RequestParam(value="subscriptionType", required=false) String subscriptionType,
			@RequestParam(value="price", required=false) String price,
			@RequestParam(value="movieId", required=false) String movieId,
			HttpSession session,
			WebRequest request
	) {
		CustomerSubscription customerSubscription = null;
		System.out.println("username:::"+username);
		System.out.println("SubscriptionType:::"+SubscriptionType.valueOf(subscriptionType));
		if(SubscriptionType.valueOf(subscriptionType)!=null)
			customerSubscription= customerService.startSubscription(username,Integer.parseInt(noOfMonths) , SubscriptionType.valueOf(subscriptionType),Integer.parseInt(price),Integer.parseInt(movieId));
		else
			return new ResponseEntity<>("INVALID SUBSCRIPTION TYPE", HttpStatus.OK);

		if(customerSubscription!=null)
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);

		return new ResponseEntity<>("FAILURE", HttpStatus.OK);
	}



}
