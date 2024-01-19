package com.orgconnect.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orgconnect.management.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
    
}
