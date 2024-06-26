/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.service;

import com.ybanez.microservice.entity.Customer;
import com.ybanez.microservice.entity.Customer.CustomerType;
import com.ybanez.microservice.entity.CustomerData;
import com.ybanez.microservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaeshi
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(CustomerData data) throws Exception {
       //validate inputs
       Customer customer = new Customer(data.getCustomerName(), data.getCustomerMobile(), data.getCustomerEmail(), data.getAddress1(),
       data.getAddress2(), data.getType());
       customer = customerRepository.save(customer);
       return customer;
    }

    @Override
    public Customer getCustomer(String id) throws Exception {
        Customer customer = customerRepository.findById(Integer.valueOf(id)).orElse(null);
        return customer;
    }
}
