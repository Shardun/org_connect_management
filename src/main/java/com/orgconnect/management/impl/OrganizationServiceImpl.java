package com.orgconnect.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgconnect.management.Exceptions.ResourceNotFoundException;
import com.orgconnect.management.entities.Organization;
import com.orgconnect.management.repositories.OrganizationRepository;
import com.orgconnect.management.services.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
        
    }

    @Override
    public Organization getOrganizationById(Long organizationId) {
        return organizationRepository.findById(organizationId).orElseThrow(()->
            new ResourceNotFoundException("Given org id is not found "+organizationId));
    }

    @Override
    public List<Organization> getAllOrganization() {
       return organizationRepository.findAll();
    }
    
}
