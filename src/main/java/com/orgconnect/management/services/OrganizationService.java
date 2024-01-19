package com.orgconnect.management.services;
import java.util.List;

import com.orgconnect.management.entities.Organization;

public interface OrganizationService {
    //create organization
    Organization createOrganization(Organization organization);
    
    //get organization by id
    Organization getOrganizationById(Long organizationId);

    //get all organization
    List<Organization> getAllOrganization();
    
}
