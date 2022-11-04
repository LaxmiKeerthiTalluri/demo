package com.rewards.demo.service;

import com.rewards.demo.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    public Long getRewards(Long transactionId, Long amount);
    public List<Transaction> getTransactions(Long customerId);

    public List<Transaction> getAllTransactions();
}
