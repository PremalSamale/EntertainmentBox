package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
