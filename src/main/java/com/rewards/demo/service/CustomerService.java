package com.rewards.demo.service;


import com.rewards.demo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public Customer getCustomerById(Long customerId);

    public List<Customer> getAllCustomers();
}
