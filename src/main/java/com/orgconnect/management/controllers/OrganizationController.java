package com.orgconnect.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orgconnect.management.entities.Organization;
import com.orgconnect.management.services.OrganizationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
    
    @Autowired
    private OrganizationService organizationService;

    //create
    @PostMapping
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        Organization createOrganization = organizationService.createOrganization(organization);
        return new ResponseEntity<>(createOrganization, HttpStatus.CREATED);
    }
    
    //get organization by id
    @GetMapping("{organizationId}")
    public ResponseEntity<Organization>  getOrganizationById(@PathVariable Long organizationId) {
       Organization organization = organizationService.getOrganizationById(organizationId);
        return organization != null ? ResponseEntity.ok(organization) : ResponseEntity.notFound().build();
    }
    
    //get all organization
    @GetMapping
     public ResponseEntity<List<Organization>>  getAllOrganization() {
        return ResponseEntity.status(HttpStatus.OK).body(organizationService.getAllOrganization());
    }
}
