package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.Movie;

import java.util.Date;
import java.util.List;

public interface CustomerService {

    //The subscription can start at any day, and the subscription fee for the current month ends at 12 am the same day next month.
    // If next month does not have the same day, then it ends at the last day of next month.
    // For example, if you start your subscription on Jan 30 and only paid $10 monthly fee, the fee is good until the last day of February,
    // and you must pay/renew your subscription by 12 AM March 1st.
    void startSubscription(Customer customerId, Integer noOfMonths);


    //View billing status: a subscription user must be able to find out when his subscription is up for renewal.
    Date viewBillingStatus(Customer customerId);

    //Filtering Features to be implemented in front end
    List<Movie> getAllMovies();




}
