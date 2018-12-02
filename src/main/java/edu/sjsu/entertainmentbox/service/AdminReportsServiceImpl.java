package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.model.Customer;

import java.util.List;

public class AdminReportsServiceImpl implements AdminReportsService {

    //month by month for the last 12 calendar months, including the current month
    @Override
    public List<Customer> getUniqueSubscriptionUsers() {
        return null;
    }

    // unique pay-per-view users (those who have played at least one Pay-Per-View movie,
    // either paid as non-subscriber, or paid for PayPerViewOnly as a subscriber)
    //month by month for the last 12 calendar months, including the current month
    @Override
    public List<Customer> getUniquePayPerViewUsers() {
        return null;
    }

    //those who played at least one movie in the month
    //month by month for the last 12 calendar months, including the current month
    @Override
    public List<Customer> getUniqueActiveUsers() {
        return null;
    }

    //all registered users
    //month by month for the last 12 calendar months, including the current month
    @Override
    public List<Customer> getUniqueUsers() {
        return null;
    }

    //for the last 12 calendar months, including the current month
    @Override
    public List<Integer> getMontlySubscriptionIncome() {
        return null;
    }

    //for the last 12 calendar months, including the current month
    @Override
    public List<Integer> getMontlyPayPerViewIncome() {
        return null;
    }

    //for the last 12 calendar months, including the current month
    @Override
    public List<Integer> getMontlyTotalIncome() {
        return null;
    }
}
