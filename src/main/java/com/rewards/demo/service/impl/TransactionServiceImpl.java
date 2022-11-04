package com.rewards.demo.service.impl;

import com.rewards.demo.entity.Transaction;
import com.rewards.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    List<Transaction> transactions = getAllTransactions();
    @Override
    public Long getRewards(Long transactionId, Long amount) {
        Long points = Long.valueOf(0);
        if (amount > 50 && amount <= 100) {
            points += (amount.intValue() - 50) * 1;

        }

        if (amount > 100) {
            points += 50;  //1 point for every dollar spent over $50
            points += (amount.intValue() - 100) * 2;  //2 points for every dollar spent over $100
        }

        return points;
    }

    @Override
    public List<Transaction> getTransactions(Long customerId) {
        List<Transaction> matchingObjects = transactions.stream().
                filter(p -> p.getCustomerId().equals(customerId)).
                collect(Collectors.toList());
        return matchingObjects;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        Transaction transaction1 = new Transaction(1L, 123L, Timestamp.from(Instant.now()), 120);
        Transaction transaction2 = new Transaction(2L, 123L, Timestamp.from(Instant.now()), 120);
        Transaction transaction3 = new Transaction(3L, 123L, Timestamp.from(Instant.now()), 120);
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        return  transactions;
    }


}
