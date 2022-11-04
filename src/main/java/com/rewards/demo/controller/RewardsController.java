package com.rewards.demo.controller;

import com.rewards.demo.entity.Customer;
import com.rewards.demo.entity.Transaction;
import com.rewards.demo.model.Rewards;
import com.rewards.demo.repository.CustomerRepository;
import com.rewards.demo.service.CustomerService;
import com.rewards.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RewardsController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "customer/{customerId}/rewards",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getRewardsByCustomerId(@PathVariable("customerId") Long customerId){
        Customer customer = customerService.getCustomerById(customerId);
        if(customer == null)
        {
        	throw new RuntimeException("Invalid / Missing customer Id ");
        }
        List<Transaction> transactionIds = transactionService.getTransactions(customerId);
        Long totalRewards = Long.valueOf(0);
        for(Transaction transaction: transactionIds){
            Long transactionIdRewards = transactionService.getRewards(transaction.getTransactionId(), (long) transaction.getTransactionAmount());
            totalRewards = totalRewards+ transactionIdRewards;
        }
        return new ResponseEntity<>(totalRewards,HttpStatus.OK);
    }

    @GetMapping(value = "/rewards",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getRewards(){

        List<Transaction> transactionIds = transactionService.getAllTransactions();
        Long totalRewards = Long.valueOf(0);
        for(Transaction transaction: transactionIds){
            Long transactionIdRewards = transactionService.getRewards(transaction.getTransactionId(), (long) transaction.getTransactionAmount());
            totalRewards = totalRewards+ transactionIdRewards;
        }
        return new ResponseEntity<>(totalRewards,HttpStatus.OK);
    }


    @GetMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaction>> getTransactions(){

        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions,HttpStatus.OK);
    }

}
