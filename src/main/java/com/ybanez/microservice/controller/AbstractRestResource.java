/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author jaeshi
 */
public class AbstractRestResource {
    
    //validation
    public Map<String, String> validate(BindingResult result) {
        Map<String, String> identifiedError = new HashMap<>();
       if(result.hasErrors()) {
           for(FieldError error : result.getFieldErrors()) {
               String field = error.getField();
               String errorMessage = error.getDefaultMessage();
               identifiedError.put(field, errorMessage);
               return identifiedError;
           }
       } return null;
    }
    
    
    
    public ResponseEntity<?> addedSuccessfully(String id, Object data) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(data);
    }
    
    public ResponseEntity<?> badRequest(Object data) {
        return ResponseEntity.badRequest().body(data);
    }
    
    public ResponseEntity<?> onSuccess(Object data) {
        return ResponseEntity.ok().body(data);
    }
    
}
