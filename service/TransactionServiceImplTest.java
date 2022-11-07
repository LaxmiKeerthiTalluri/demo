package com.example.demo.service;

import com.rewards.demo.entity.Transaction;
import com.rewards.demo.service.TransactionService;
import org.junit.Before;
import org.mockito.Mock;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;


public class TransactionServiceImplTest  {


    @Mock
    TransactionService transactionService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetRewardsOfTransaction() throws Exception {
        Transaction  t = new Transaction(1L, 123L, Timestamp.from(Instant.now()), 120);
        Long t2 = transactionService.getRewardsOfTransaction(1L, Double.valueOf(Long.valueOf(120)));
        assertEquals(Long.valueOf(90), t2);

    }

    @Test
    public void testGetTransactionsOfCustomer() {
        List<Transaction> t3 = transactionService.getTransactionsOfCustomer(123L);
        assertEquals(3, t3.size());
    }

    @Test
    public void testGetTransactionsOfCustomerZer0() {
        List<Transaction> t3 = transactionService.getTransactionsOfCustomer(125L);
        assertEquals(0, t3.size());
    }


}
