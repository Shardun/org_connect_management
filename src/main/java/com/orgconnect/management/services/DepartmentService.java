package com.orgconnect.management.services;

import java.util.List;

import com.orgconnect.management.entities.Department;

public interface DepartmentService {
    // Get all Departments
    List<Department> getAllDepartments();

    // Get Department by ID
    Department getDepartmentById(Long id);

    // Create a new Department
    Department createDepartment(Department department);

    // Update an existing Department
    Department updateDepartment(Long id, Department department);

    // Delete a Department by ID
    boolean deleteDepartment(Long id);
}
