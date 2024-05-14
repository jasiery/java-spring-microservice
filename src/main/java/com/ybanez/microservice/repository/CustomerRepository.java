/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.repository;

import com.ybanez.microservice.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jaeshi
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
