package com.orgconnect.management.services;

import java.util.List;

import com.orgconnect.management.entities.Employee;

public interface EmployeeService {
    // Get all employees
    List<Employee> getAllEmployees();

    // Get employee by ID
    Employee getEmployeeById(Long id);

    // Create a new employee
    Employee createEmployee(Employee employee);

    // Update an existing employee
    Employee updateEmployee(Long id, Employee employee);

    // Delete a employee by ID
    boolean deleteEmployee(Long id);

}
