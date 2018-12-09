package edu.sjsu.entertainmentbox.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.model.MovieAvailability;
import edu.sjsu.entertainmentbox.model.MovieInformation;
import edu.sjsu.entertainmentbox.model.SubscriptionType;
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
			String link=m.getMovie();
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
}
