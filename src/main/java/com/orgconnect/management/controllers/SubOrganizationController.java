package com.orgconnect.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orgconnect.management.entities.SubOrganization;
import com.orgconnect.management.services.SubOrganizationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/suborganizations")
public class SubOrganizationController {
    
    @Autowired
    private SubOrganizationService subOrganizationService;

   
    //create
    @PostMapping
    public ResponseEntity<SubOrganization> createSubOrganization(@RequestBody SubOrganization subOrganization) {
        SubOrganization createSubOrganization = subOrganizationService.createSubOrganization(subOrganization);
        return new ResponseEntity<>(createSubOrganization, HttpStatus.CREATED);
    }
    
    //get organization by id
    @GetMapping("{subOrganizationId}")
    public ResponseEntity<SubOrganization>  getOrganizationById(@PathVariable Long subOrganizationId) {
       SubOrganization subOrganization = subOrganizationService.getSubOrganizationById(subOrganizationId);
        return subOrganization != null ? ResponseEntity.ok(subOrganization) : ResponseEntity.notFound().build();
    }
    
    //get all organization
    @GetMapping
     public ResponseEntity<List<SubOrganization>>  getAllOrganization() {
        return ResponseEntity.status(HttpStatus.OK).body(subOrganizationService.getAllSubOrganization());
    }
}
