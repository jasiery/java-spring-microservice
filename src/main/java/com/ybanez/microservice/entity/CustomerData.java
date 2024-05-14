/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.entity;

import com.ybanez.microservice.entity.Customer.CustomerType;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author jaeshi
 */
@Data
public class CustomerData {
    
    @NotNull(message = "Name is required field")
    private String name;
    
    @NotNull(message = "Mobile is required field")
    private String mobile;
      
    @NotNull(message = "Email is required field")
    private String email;
    
    @NotNull(message = "Address 1 is required field")
    private String address1;
    
    @NotNull(message = "Address 2 is required field")
    private String address2;

    @NotNull(message = "Type is required field")
    private CustomerType type;
}
