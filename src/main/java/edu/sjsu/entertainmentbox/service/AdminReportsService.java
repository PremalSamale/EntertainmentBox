package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.model.Customer;

import java.util.List;

public interface AdminReportsService {

    //month by month for the last 12 calendar months, including the current month
    List<Customer> getUniqueSubscriptionUsers();

    // unique pay-per-view users (those who have played at least one Pay-Per-View movie,
    // either paid as non-subscriber, or paid for PayPerViewOnly as a subscriber)
    //month by month for the last 12 calendar months, including the current month
    List<Customer> getUniquePayPerViewUsers();

    //those who played at least one movie in the month
    //month by month for the last 12 calendar months, including the current month
    List<Customer> getUniqueActiveUsers();

    //all registered users
    //month by month for the last 12 calendar months, including the current month
    List<Customer> getUniqueUsers();

    //for the last 12 calendar months, including the current month
    List<Integer> getMontlySubscriptionIncome();

    //for the last 12 calendar months, including the current month
    List<Integer> getMontlyPayPerViewIncome();

    //for the last 12 calendar months, including the current month
    List<Integer> getMontlyTotalIncome();


}
