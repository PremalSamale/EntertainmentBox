package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.CustomerSubscription;

public interface CustomerDao {
	public Customer getCustomer(String emailaddress);
	public void saveSubscription(CustomerSubscription customerSubscription, Customer customer);
	public void saveCustomer(Customer customer);
}
