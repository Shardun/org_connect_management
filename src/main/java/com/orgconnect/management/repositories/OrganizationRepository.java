package com.orgconnect.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orgconnect.management.entities.Organization;

public interface OrganizationRepository extends JpaRepository<Organization,Long>{
    
}
