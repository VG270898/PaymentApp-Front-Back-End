package com.bill.repository;

import com.bill.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, UUID> {
    List<AccountTransaction> findBySequenceId(int sequenceId);
}
