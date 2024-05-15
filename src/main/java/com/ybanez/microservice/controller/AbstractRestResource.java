/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ybanez.microservice.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
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
        Map<String, String> identifiedErrors = new HashMap<>();

        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                identifiedErrors.put(error.getField(), error.getDefaultMessage());
            }
        }

        return identifiedErrors.isEmpty() ? null : identifiedErrors;
    }

    public ResponseEntity<?> addedSuccessfully(String id, Object data) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    public ResponseEntity<?> badRequest(Object data) {
        return ResponseEntity.badRequest().body(data);
    }

    public ResponseEntity<?> notFound(Object data) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(data);
    }

    public ResponseEntity<?> hasFound(Object data) {
        return ResponseEntity.status(HttpStatus.FOUND).body(data);
    }

    public ResponseEntity<?> onSuccess(Object data) {
        return ResponseEntity.ok().body(data);
    }

}
