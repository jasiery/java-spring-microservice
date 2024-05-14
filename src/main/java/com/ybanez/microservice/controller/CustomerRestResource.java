/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.controller;

import com.ybanez.microservice.entity.Customer;
import com.ybanez.microservice.entity.CustomerData;
import com.ybanez.microservice.entity.CustomerResult;
import com.ybanez.microservice.service.CustomerService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jaeshi
 */
@RestController
@RequestMapping("/api/v1/account")
public class CustomerRestResource extends AbstractRestResource{
    
    @Autowired
    private CustomerService customerService;
    
    @PostMapping
    public ResponseEntity<?> addCustomer(@Valid CustomerData data, 
            BindingResult result) throws Exception {
        CustomerResult customerResult = new CustomerResult();
        Map<String, String> identifiedError = validate(result);
        if(identifiedError != null) {
            customerResult
                    .markAsFailed(identifiedError.entrySet().stream().findFirst().get().getKey(), 
                    identifiedError.entrySet().stream().findFirst().get().getValue());
            return badRequest(customerResult);
        }
        Customer newCustomer = customerService.addCustomer(data);
        customerResult.markAsSuccess(String.valueOf(newCustomer.getId()));
        return addedSuccessfully(String.valueOf(newCustomer.getId()), customerResult);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable String id) throws Exception {
        CustomerResult result = new CustomerResult();
        Customer customer = customerService.getCustomer(id);
        if(customer == null) {
            return notFound(result.markAsNotFound());
        }else {
            result.setCustomer(customer);
            result.markAsFound();
            return hasFound(result);
        }
    }
}
