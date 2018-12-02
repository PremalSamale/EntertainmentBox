package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
