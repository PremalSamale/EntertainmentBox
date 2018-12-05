package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmailAddress(String emailAddress);

    //@Query("select c from Customer c where c.customerId = :customerId and c.movies.movieId = :movieId")
    Optional<Customer> findByCustomerIdAndMovies_MovieId(@Param("customerId") Integer customerId, @Param("movieId") Integer movieId);

    @Query("select c from Customer c join c.movies m join m.moviePlayLogs p order by p.mveStartTs")
    Optional<List<Customer>> findAllOrderByCustomerMoviesMoviePlayLogsMveStartTs();
}
