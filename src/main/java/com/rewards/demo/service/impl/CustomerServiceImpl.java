package com.rewards.demo.service.impl;

import com.rewards.demo.entity.Customer;
import com.rewards.demo.entity.Transaction;
import com.rewards.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    List<Customer> customerList = getAllCustomers();

    @Override
    public Customer getCustomerById(Long customerId) {
        List<Customer> matchingObjects = customerList.stream().
                filter(p -> p.getCustomerId().equals(customerId)).
                collect(Collectors.toList());
        return matchingObjects.get(0);
    }

    @Override
    public List<Customer> getAllCustomers() {
        Customer customer1 = new Customer( 123L, "Keerthi");
        Customer customer2 = new Customer(124L, "Lakshmo");
        Customer customer3 = new Customer(125L,"Lakshmi Keerthi" );
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        return  customers;
    }
}
