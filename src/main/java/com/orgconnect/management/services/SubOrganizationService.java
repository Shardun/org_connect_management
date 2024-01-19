package com.orgconnect.management.services;
import java.util.List;

import com.orgconnect.management.entities.SubOrganization;

public interface SubOrganizationService {
    //create organization
    SubOrganization createSubOrganization(SubOrganization subOrganization);
    
    //get organization by id
    SubOrganization getSubOrganizationById(Long subOrganizationId);

    //get all organization
    List<SubOrganization> getAllSubOrganization();
    
}
