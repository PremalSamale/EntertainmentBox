package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Customer;
import edu.sjsu.entertainmentbox.model.MoviePlayLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface MoviePlayLogRepository extends JpaRepository<MoviePlayLog, Integer> {

    /*@Query("select p from MoviePlayLog p where p.movie.movieId = :movieId and p.mveStartTs > :startDate  GROUP   BY  DATE(p.mveStartTs)")
    Optional<List<MoviePlayLog>> noOfPlaysForAMovie(@Param("startDate") Date startDate, @Param("movieId") Integer movieId);*/

    //List<MoviePlayLog> findByCustomerCustomerId(Integer customerId);

   Optional<Set<MoviePlayLog>> findByCustomerEmailAddressOrderByMveStartTsDesc(String emailAddress);

   @Query(value = "select innerTable.email from (select it.ea as email, count(*) as ct from (SELECT m.customer.emailAddress as ea  FROM MoviePlayLog m where m.mveStartTs between current_date and date_add(current_date, interval :timePeriod day) GROUP BY m.customer.emailAddress, m.movie.movieId, DATE(m..mveStartTs)) as it group by it.ea order by ct desc) innerTable limit 10", nativeQuery = true)
   List<String> getTop10CustomersByNoOfPlays(@Param("timePeriod") Integer timePeriod);


}
