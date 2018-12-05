package edu.sjsu.entertainmentbox.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.entertainmentbox.dao.CustomerDao;
import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.CustomerSubscription;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.model.SubscriptionType;
import edu.sjsu.entertainmentbox.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;


	@Transactional
	public Customer getCustomer(String emailAddress) {
		return customerDao.getCustomer(emailAddress);
	}


	@Transactional
	public void saveSubscription(String emailAddress, int price, int noOfMonths, SubscriptionType subscriptionType, Movie movie) throws ParseException {
		CustomerSubscription customerSubscription = new CustomerSubscription();
		customerSubscription.setPrice(price);
		TimeZone.setDefault(TimeZone.getTimeZone("PST"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		String stDate = format.format( calendar.getTime() );
		Date startDate = format.parse(stDate);
		Date endDate = getEndDate(calendar, noOfMonths);
		customerSubscription.setSubscriptionStartDate(startDate);
		customerSubscription.setSubscriptionEndDate(endDate);
		customerSubscription.setSubscriptionTS(startDate);
		customerSubscription.setSubscriptionType(SubscriptionType.SUBSCRIPTION_ONLY);
		customerSubscription.setMovie(null);
		
		Customer customer = getCustomer(emailAddress);
		if (customer == null) {
			customer = new Customer();
			customer.setEmailAddress(emailAddress);
		}
		
		customerSubscription.setCustomer(customer);

		customerDao.saveSubscription(customerSubscription, customer);
	}


	private Date getEndDate(Calendar calendar, int noOfMonths) {
		calendar.add(Calendar.MONTH, noOfMonths);
		calendar.add(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}


	@Override
	public List<Movie> searchMovie(String searchText) {
		List<Movie> result = new ArrayList<Movie>();
		List<Movie> allMovies = customerDao.searchMovie(searchText);
		for(Movie movie: allMovies) {
			if (movie.getTitle().toLowerCase().contains(searchText.toLowerCase())) {
				result.add(movie);
			}
		}
		return result;
	}

}
