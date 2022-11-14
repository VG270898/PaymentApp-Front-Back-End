package com.bill.service;

import com.bill.model.AccountTransaction;
import com.bill.model.Bills;
import com.bill.model.RegisteredBillers;

import java.util.List;

public interface IBillService {

    public RegisteredBillers registerBiller(RegisteredBillers registeredBillers);
    public List<RegisteredBillers> showRegisteredBillers(int accountNumber);

    public Bills generateBill(Bills bills);

    public List<Bills> showGeneratedBills(int accountNumber);
    public String deleteRegisteredBiller(int billerSequenceId);

    public AccountTransaction doTransaction(AccountTransaction accountTransaction);

    public List<AccountTransaction> viewAllTransaction(int accountNumber);

}
