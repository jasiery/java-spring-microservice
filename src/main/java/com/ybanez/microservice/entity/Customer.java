/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 *
 * @author jaeshi
 */
@Entity
@Table(name = "spm_customer")
@Data
@NoArgsConstructor
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmr_id")
    private int id;
    
    @Column(name = "cmr_name")
    private String name;
    
    @Column(name = "cmr_mobile")
    private String mobile;
    
    @Column(name = "cmr_email")
    private String email;
    
    @Column(name = "cmr_address1")
    private String address1;
    
    @Column(name="cmr_address2")
    private String address2;
    
    @Column(name = "cmr_type")
    private CustomerType type;
    
    public enum CustomerType {
        S,Y
    }
    
    @JsonIgnore
    public Customer(String name, String mobile,
            String email, String address1, String address2,
            CustomerType type) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.type = type;
    }
    
    
}
