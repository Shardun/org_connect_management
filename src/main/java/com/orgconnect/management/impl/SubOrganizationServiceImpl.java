package com.orgconnect.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgconnect.management.Exceptions.ResourceNotFoundException;
import com.orgconnect.management.entities.Organization;
import com.orgconnect.management.entities.SubOrganization;
import com.orgconnect.management.repositories.OrganizationRepository;
import com.orgconnect.management.repositories.SubOrganizationRepository;
import com.orgconnect.management.services.SubOrganizationService;

@Service
public class SubOrganizationServiceImpl implements SubOrganizationService {

    @Autowired
    private SubOrganizationRepository subOrganizationRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public SubOrganization createSubOrganization(SubOrganization subOrganization) {

        if(subOrganization.getOrganization()!=null && subOrganization.getOrganization().getOrganizationId()!= null){
            Organization org = organizationRepository.findById(subOrganization.getOrganization().getOrganizationId()).orElse(null);
            if(org != null){
                subOrganization.setOrganization(org);
            }
            else{
                 throw new ResourceNotFoundException("Given organization id is not found "+subOrganization.getOrganization().getOrganizationId());
            }
        }
        else{
                //if org id is missing from payload
                throw new ResourceNotFoundException("Organization or Organization id is missing");
        }

        return subOrganizationRepository.save(subOrganization);
        
    }

    @Override
    public SubOrganization getSubOrganizationById(Long subOrganizationId) {
        return subOrganizationRepository.findById(subOrganizationId).orElseThrow(() ->  
        new ResourceNotFoundException("Given sub organization id is not found "+subOrganizationId));
    }

    @Override
    public List<SubOrganization> getAllSubOrganization() {
       return subOrganizationRepository.findAll();
    }
    
}
