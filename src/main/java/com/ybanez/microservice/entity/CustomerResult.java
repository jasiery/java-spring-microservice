/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author jaeshi
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResult {
    
    @JsonIgnore
    private Customer customer;
    
    private String customerNumber;
    
    private String customerName;
    
    private String customerMobile;
    
    private String customerEmail;
    
    private String address1;
    
    private String address2;
    
    private int  transactionStatusCode;
    
    private String transactionStatusDescription;
    
    @JsonIgnore
    public CustomerResult markAsSuccess(String customerNumber){
        this.customerNumber = customerNumber;
        this.transactionStatusCode = HttpStatus.CREATED.value();
        this.transactionStatusDescription = "Customer account created";
        return this;
    }
    
    @JsonIgnore
    public CustomerResult markAsFailed(String field, String message){
        this.transactionStatusCode = HttpStatus.BAD_REQUEST.value();
        this.transactionStatusDescription = message;
        return this;
    }
    
    @JsonIgnore
    public CustomerResult markAsNotFound(){
        this.transactionStatusCode = HttpStatus.UNAUTHORIZED.value();
        this.transactionStatusDescription = "Customer not found";
        return this;
    }
    
    
    @JsonIgnore
    public CustomerResult markAsFound(){
        this.customerNumber = this.customer.getCustomerNumber();
        this.customerName = this.customer.getName();
        this.customerEmail = this.customer.getEmail();
        this.customerMobile = this.customer.getMobile();
        this.address1 = this.customer.getAddress1();
        this.address2 = this.customer.getAddress2();
        this.transactionStatusCode = HttpStatus.FOUND.value();
        this.transactionStatusDescription = "Customer Accound found";
        return this;
    }
}
