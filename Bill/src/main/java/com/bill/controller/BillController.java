package com.bill.controller;


import com.bill.model.AccountTransaction;
import com.bill.model.Bills;
import com.bill.model.RegisteredBillers;
import com.bill.repository.BillRepo;
import com.bill.repository.RegisteredBillerRepo;
import com.bill.service.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BillController {

    @Autowired
    private RegisteredBillerRepo registeredBillerRepo;

    @Autowired
    private BillServiceImpl billServiceImpl;

    @Autowired
    private BillRepo billRepo;

    @PostMapping("/biller/register")
    public ResponseEntity registerBiller(@RequestBody RegisteredBillers registeredBillers){
        return ResponseEntity.ok(billServiceImpl.registerBiller(registeredBillers));
    }

    @GetMapping("/getbillers/{accountNumber}")
    public ResponseEntity getBiller(@PathVariable int accountNumber){
        return ResponseEntity.ok(billServiceImpl.showRegisteredBillers(accountNumber));
    }


    @PostMapping("/bill/generate")
    public ResponseEntity generateBill(@RequestBody Bills bills){
        return ResponseEntity.ok(billServiceImpl.generateBill(bills));
    }

    @GetMapping("/getbills/{accountNumber}")
    public ResponseEntity getBills(@PathVariable int accountNumber){
        return ResponseEntity.ok(billServiceImpl.showGeneratedBills(accountNumber));
    }


    @PutMapping("/account/transaction")
    public ResponseEntity accountTransaction(@RequestBody AccountTransaction accountTransaction){
        return ResponseEntity.ok(billServiceImpl.doTransaction(accountTransaction));
    }

    @GetMapping("/transaction/{sequenceId}")
    public ResponseEntity showTransactions(@PathVariable int sequenceId){
        return ResponseEntity.ok(billServiceImpl.viewAllTransaction(sequenceId));
    }
}
