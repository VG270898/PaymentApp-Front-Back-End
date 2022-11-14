package com.bill.service;

import com.bill.model.AccountTransaction;
import com.bill.model.Bills;
import com.bill.model.RegisteredBillers;
import com.bill.repository.AccountTransactionRepo;
import com.bill.repository.BillRepo;
import com.bill.repository.RegisteredBillerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BillServiceImpl implements IBillService{

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private RegisteredBillerRepo registeredBillerRepo;


    @Autowired
    private AccountTransactionRepo accountTransactionRepo;

    @Override
    public RegisteredBillers registerBiller(RegisteredBillers registeredBillers) {
        registeredBillers.setAutoPay(false);
        registeredBillers.setAutoPayLimit(600);
        return registeredBillerRepo.save(registeredBillers);
    }

    @Override
    public List<RegisteredBillers> showRegisteredBillers(int accountNumber) {
        return registeredBillerRepo.findByAccountNumber(accountNumber).stream().toList();
    }

    @Override
    public Bills generateBill(Bills bills) {
        bills.setStatus("Pending");
        return billRepo.save(bills);
    }

    @Override
    public List<Bills> showGeneratedBills(int accountNumber) {
        Collection<Long> consumerNumbers = registeredBillerRepo.findConsumerNumberByAccountNumber(accountNumber);
        System.out.println(consumerNumbers);

        return billRepo.findBillsByConsumerNumber(consumerNumbers);
    }

    @Override
    public String deleteRegisteredBiller(int billerSequenceId) {
        return null;
    }

    @Override
    public AccountTransaction doTransaction(AccountTransaction accountTransaction) {
        UUID uuid = UUID.randomUUID();
        accountTransaction.setTransactionReference(uuid);
        accountTransaction.setDateTime(new Date(System.currentTimeMillis()));
        Bills bills = billRepo.findByBillSequenceId(accountTransaction.getBillReferenceNumber());
        bills.setStatus("Paid");
        billRepo.save(bills);
        return accountTransactionRepo.save(accountTransaction);
    }

    @Override
    public List<AccountTransaction> viewAllTransaction(int sequenceId){
        return accountTransactionRepo.findBySequenceId(sequenceId).stream().toList();
    }
}
