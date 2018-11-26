package edu.sjsu.entertainmentbox.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.entertainmentbox.dao.CustomerDao;
import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.CustomerSubscription;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.model.SubscriptionType;
import edu.sjsu.entertainmentbox.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;


	@Override
	public Customer getCustomer(String emailAddress) {
		return customerDao.getCustomer(emailAddress);
	}


	@Override
	public void saveSubscription(String emailAddress, int price, int noOfMonths, SubscriptionType subscriptionType, Movie movie) {
		CustomerSubscription customerSubscription = new CustomerSubscription();
		customerSubscription.setPrice(price);
		customerSubscription.setSubscriptionStartDate(new Date(118, 10, 25));
		customerSubscription.setSubscriptionEndDate(new Date(119, 0, 25));
		customerSubscription.setSubscriptionTS(new Date(118, 10, 25));
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

}
