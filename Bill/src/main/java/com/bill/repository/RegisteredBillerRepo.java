package com.bill.repository;

import com.bill.model.RegisteredBillers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface RegisteredBillerRepo extends JpaRepository<RegisteredBillers,Integer> {

    List<RegisteredBillers> findByAccountNumber(int accountNumber);

    @Query("SELECT u.consumerNumber FROM RegisteredBillers u WHERE u.accountNumber = ?1")
    Collection<Long> findConsumerNumberByAccountNumber(int accountNumber);
}
