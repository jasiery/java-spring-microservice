/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author jaeshi
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResult {
    
    private String customerNumber;
    
    private int  transactionStatusCode;
    
    private String transactionStatusDescription;
    
    @JsonIgnore
    public CustomerResult markAsSuccess(String customerNumber){
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
}
