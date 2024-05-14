/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.service;

import com.ybanez.microservice.entity.Customer;
import com.ybanez.microservice.entity.CustomerData;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaeshi
 */
@Service
public interface CustomerService {
    
    Customer addCustomer(CustomerData data) throws Exception;
    
    Customer getCustomer(String id) throws Exception;
}
