package edu.sjsu.entertainmentbox.dao;

import edu.sjsu.entertainmentbox.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
