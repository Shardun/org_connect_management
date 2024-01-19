package com.orgconnect.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orgconnect.management.entities.Department;
import com.orgconnect.management.entities.Employee;
import com.orgconnect.management.entities.Role;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    List<Employee> findByRole(Role role);

    List<Employee> findByDepartment(Department department);
    
}
