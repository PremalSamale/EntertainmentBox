package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.CustomerSubscription;
import edu.sjsu.entertainmentbox.model.Movie;
import edu.sjsu.entertainmentbox.model.SubscriptionType;

public interface CustomerService {
	public Customer getCustomer(String emailaddress);
	public void saveSubscription(String emailAddress, int price, int noOfMonths, SubscriptionType subscriptionType, Movie movie);
}
