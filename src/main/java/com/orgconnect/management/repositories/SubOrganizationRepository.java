package com.orgconnect.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orgconnect.management.entities.SubOrganization;

public interface SubOrganizationRepository extends JpaRepository<SubOrganization,Long>{
    
}
