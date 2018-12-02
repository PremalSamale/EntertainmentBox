package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.CustomerSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSubscriptionRepository extends JpaRepository<CustomerSubscription, Long> {
}
