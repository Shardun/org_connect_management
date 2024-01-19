package com.orgconnect.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orgconnect.management.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{
    
}
