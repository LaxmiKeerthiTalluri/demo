package com.example.demo.service;

import com.rewards.demo.entity.Customer;
import com.rewards.demo.service.CustomerService;
import com.rewards.demo.service.TransactionService;
import org.junit.Before;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;


public class CustomerServiceImplTest  {

    @Mock
    CustomerService customerService ;

    @Mock
    TransactionService transactionService;

    List<Customer> customerList = getAllCustomers();


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomerByIdSuccess() {
        Customer expected = new Customer(123L, "Keerthi");
        List<Customer> customerList = getAllCustomers();
        System.out.println(customerList.size());
        Customer actual = customerService.getCustomerById(123L);
        System.out.println(actual);
        assertEquals(expected.getCustomerId(), actual.getCustomerId());
//        assertEquals(expected.get);
    }

    @Test
    public void testGetCustomerByIdNotFound() {
        Customer actual = customerService.getCustomerById(99L);
        assertEquals(null, actual);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        System.out.println(customers.size());
        assertEquals(3, customers.size());
    }

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
