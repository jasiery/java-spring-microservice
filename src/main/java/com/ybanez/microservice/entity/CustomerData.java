/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.entity;

import com.ybanez.microservice.entity.Customer.CustomerType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author jaeshi
 */
@Data
public class CustomerData {
    
    @NotBlank(message = "Name is required field")
    private String customerName;
    
    @NotBlank(message = "Mobile is required field")
    private String customerMobile;
      
    @NotBlank(message = "Email is required field")
    @Email(message = "Invalid email format")
    private String customerEmail;
    
    @NotBlank(message = "Address 1 is required field")
    private String address1;
    
    @NotBlank(message = "Address 2 is required field")
    private String address2;

    @NotNull(message = "Type is required field")
    private CustomerType type;
}
