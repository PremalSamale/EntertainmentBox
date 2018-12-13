package edu.sjsu.entertainmentbox.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import edu.sjsu.entertainmentbox.model.CustomerSubscription;
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

	@RequestMapping(value="/user/startSubscription", method={RequestMethod.POST})
	public ModelAndView startSubscription(HttpServletRequest request) {
		ModelAndView mv= new ModelAndView("startSubscription");
		try {
			int price2=0;
			int noOfMonth =0;
			int cost =0;
			String noOfMonths = request.getParameter("noOfMonths");
			if (noOfMonths == null || noOfMonths.equals("")) {
				mv= new ModelAndView("customer");
				mv.addObject("subscriptionErrMsg", "Please enter number of months");
				return mv;
			}
			String price = request.getParameter("price");
			String emailAddress = request.getUserPrincipal().getName();
			if(price!=null && noOfMonths!=null) {
				 price2 = Integer.parseInt(price);
				 noOfMonth = Integer.parseInt(noOfMonths);
				 cost =noOfMonth* price2;
			}else {
				 price2=10;
				 noOfMonth =1;
				 cost =10;
			}
			mv.addObject("emailAddress", emailAddress);
			mv.addObject("cost", cost);
			mv.addObject("noOfMonth", noOfMonth);
			mv.addObject("subscriptionType", SubscriptionType.SUBSCRIPTION_ONLY);
			mv.addObject("movie", null);
		} catch (Exception e) {
			mv.addObject("subscriptionErrMsg", "Error Occured. Make sure you have entered Number of months");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/subscribe", method= {RequestMethod.POST})
	public ModelAndView subscribe(HttpServletRequest request) throws ParseException {
		ModelAndView mv= new ModelAndView("subscribe");
		try {
			int noOfMonth = Integer.parseInt( request.getParameter("noOfMonth") );
			String subscriptionType = request.getParameter("subscriptionType");
			String movie = request.getParameter("movie");
			int cost = Integer.parseInt(request.getParameter("cost"));
			String emailAddress = request.getUserPrincipal().getName();
			Movie mve = null;
			customerService.saveSubscription(emailAddress,cost,noOfMonth, SubscriptionType.valueOf(subscriptionType), mve);
			String msg = "Thank you for subscribing!";
			mv.addObject("subscriptionMsg", msg);
		} catch (Exception e) {
			mv.addObject("subscriptionErrMsg", "Error Occured");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/submitRating", method= {RequestMethod.POST})
	public ModelAndView submitRating(HttpServletRequest request) throws ParseException {
		ModelAndView mv= new ModelAndView("successRatingSubmit");
		int stars = Integer.parseInt(request.getParameter("submitStars"));
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String emailAddress = request.getUserPrincipal().getName();
		customerService.submitRating(movieId, emailAddress, stars);
		System.out.println("##########@"+stars+"@###############");
		System.out.println("##########@"+movieId+"@###############");
		System.out.println("##########@"+emailAddress+"@###############");
		return mv;
	}

	@RequestMapping(value="/user/searchMovie", method={RequestMethod.POST})
	public ModelAndView searchMovie(HttpServletRequest request) {
		String emailAddress = request.getUserPrincipal().getName();
		String keywords = request.getParameter("keywords");
		String year = request.getParameter("year");
		String actors = request.getParameter("actors");
		String director = request.getParameter("director");
		String[] genres = request.getParameterValues("genre");
		String[] mpaaRatings = request.getParameterValues("mpaaRating");
		String numberOfStars = request.getParameter("numberOfStars");
		ModelAndView mv= new ModelAndView("customer");
		List<MovieInformation> movieInfo = customerService.searchMovie(emailAddress, keywords, year, actors, director, genres, mpaaRatings, numberOfStars);
		mv.addObject("movieInformationList", movieInfo);
		return mv;
	}
}
