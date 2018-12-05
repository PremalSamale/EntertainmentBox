package edu.sjsu.entertainmentbox.service;

import edu.sjsu.entertainmentbox.component.MoviesByRatingComponent;
import edu.sjsu.entertainmentbox.dao.*;
import edu.sjsu.entertainmentbox.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerSubscriptionRepository customerSubscriptionRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    MoviePlayLogRepository moviePlayLogRepository;
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    MovieRepository movieRepository;



   /* @Autowired
    Transaction transaction;
    @Autowired
    CustomerSubscription customerSubscription;*/

    //The subscription can start at any day, and the subscription fee for the current month ends at 12 am the same day next month.
    // If next month does not have the same day, then it ends at the last day of next month.
    // For example, if you start your subscription on Jan 30 and only paid $10 monthly fee, the fee is good until the last day of February,
    // and you must pay/renew your subscription by 12 AM March 1st.

    //Pending -- 12am is not handled yet
    @Override
    public void startSubscription(Integer customerId, Integer noOfMonths, String username) {

        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, noOfMonths);
        Date subscriptionEndDate = cal.getTime();


        Optional<Customer> customer = customerRepository.findById(customerId);

        Set<Transaction> transactions;
        Set<CustomerSubscription> customerSubscriptions;

        Customer newCustomer;// = new Customer();
        Transaction transaction;// = new Transaction();
        CustomerSubscription customerSubscription;// = new CustomerSubscription();

        transaction = new Transaction("SUBSCRIPTION", noOfMonths*10, currentDate, currentDate, "C");
        customerSubscription = new CustomerSubscription("SUBSCRIPTION", "ACTIVE", noOfMonths*10,currentDate ,currentDate, subscriptionEndDate );

        if(customer.isPresent())
        {
            System.out.println("Customer already exists!!");
            //Update the existing customer's transaction and subscription
             transactions = customer.get().getTransactions();
            ((Set) transactions).add(transaction);

            customerSubscriptions = customer.get().getSubscription();
            customerSubscriptions.add(customerSubscription);

            customer.get().setTransactions(transactions);
            customer.get().setSubscription(customerSubscriptions);

            customerRepository.save(customer.get());

        }
        else
        {
            System.out.println("New Customer!!");
            //Create new customer along with subscription
            newCustomer = new Customer();

            transactions = newCustomer.getTransactions();
            transactions.add(transaction);

            customerSubscriptions = newCustomer.getSubscription();
            customerSubscriptions.add(customerSubscription);

            newCustomer.setEmailAddress(username);
            newCustomer.setTransactions(transactions);
            newCustomer.setSubscription(customerSubscriptions);

            customerRepository.save(newCustomer);
        }


    }



    //View billing status: a subscription user must be able to find out when his subscription is up for renewal.
    @Override
    public String viewBillingStatus(Integer customerId) {

        String billingStatus = null;

        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent())
        {
            Set<CustomerSubscription> subscriptions = customer.get().getSubscription();
            for (CustomerSubscription customerSubscription:subscriptions) {
                if(customerSubscription.getSubscriptionStatus().equalsIgnoreCase("SUBSCRIPTION"))
                {
                    billingStatus = customerSubscription.getSubscriptionEndDate().toString();
                }
            }
        }
        else
        {
            billingStatus = "Customer Not Registered";
        }
        return billingStatus;
    }

    //Filtering Features to be implemented in front end
    @Override
    public List<Movie> getAllMovies() {

        return null;
    }

    //Call On Click of play - Set the return value i.e logId to session to update EndTS appropriately
    @Override
    public void updateMovieStartStatus(Integer movieId, Integer customerId) {

        Optional<Customer> customer = customerRepository.findByCustomerIdAndMovies_MovieId(customerId, movieId);

        Set<Movie> movies;
        Set<MoviePlayLog> moviePlayLogs;

        MoviePlayLog moviePlayLog = new MoviePlayLog("START", new Date(), null);

        if(customer.isPresent())
        {
            movies = customer.get().getMovies();
            //If the user watched the movie before
            if(!movies.isEmpty())
            {
                moviePlayLogs = movies.iterator().next().getMoviePlayLogs();
                moviePlayLogs.add(moviePlayLog);
            }
            else // First time playing the movie
            {
                Optional<Movie> movie = movieRepository.findById(movieId);

                if(movie.isPresent())
                {
                    moviePlayLogs = movie.get().getMoviePlayLogs();
                    moviePlayLogs.add(moviePlayLog);

                    movie.get().setMoviePlayLogs(moviePlayLogs);

                    movies.add(movie.get());


                }
                else
                {
                    System.out.println("Movie Not present in database!!!!");
                }
            }

            customer.get().setMovies(movies);
            customerRepository.save(customer.get());
        }
        //moviePlayLogRepository.save(new MoviePlayLog(new Customer().setCustomerId(customerId), "START", movieId, new Date(), null ));
    }

    //fetch the loginId from the session and update the stop TS
    @Override
    public void updateMovieStopStatus(Integer logId, Integer movieId, Integer customerId) {
       // moviePlayLogRepository.save(new MoviePlayLog(logId, customerId,"END", movieId, new Date(), null ));
    }

    //A customer can review a movie after he started playing a movie, no matter he finished playing or not.
    @Override
    public boolean checkPlayStatus(Integer logId) {
        boolean isStarted = false;
        Optional<MoviePlayLog> moviePlayLog = moviePlayLogRepository.findById(logId);
        if(moviePlayLog.isPresent())
        {
            isStarted = true;
        }

        return isStarted;
    }

    @Override
    public String saveReview(Integer movieId, Integer customerId, String review, Integer rating) {

        String saveStatus = "Successfully saved the review";
        Optional<Movie> movie = movieRepository.findById(movieId);
        if(movie.isPresent())
        {
           // ratingRepository.save(new Rating(customerId, movie.get(), rating, new Date(), review ));
        }
        else
        {
            saveStatus = "The movie selected is not found in the database";
        }

        return  saveStatus;

    }

    //Save review
    //Pending Movie names
    @Override
    public List<MoviesByRatingComponent> getTopNMoviesByRatings() {

        java.util.Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);

        List<MoviesByRatingComponent> ratings = ratingRepository.findByRating(month-1);
        return ratings;
    }


}
