package com.orgconnect.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgconnect.management.Exceptions.DeletionException;
import com.orgconnect.management.Exceptions.ResourceNotFoundException;
import com.orgconnect.management.entities.Department;
import com.orgconnect.management.entities.Employee;
import com.orgconnect.management.repositories.DepartmentRepository;
import com.orgconnect.management.repositories.EmployeeRepository;
import com.orgconnect.management.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(()-> 
            new ResourceNotFoundException("Given department id is not found "+id));
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setDepartmentId(id);
            return departmentRepository.save(department);
        }
        else{
                throw new ResourceNotFoundException("Given department id is not found "+id);
        }
    }

    @Override
    public boolean deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Given department id is not found " + id));
        // Check if the role is associated with any employees
        List<Employee> employeesWithRole = employeeRepository.findByDepartment(department);

        if (employeesWithRole.isEmpty()) {
            // If there are no associated employees, proceed with deletion
            departmentRepository.delete(department);
            return true;
        } else {
            // If there are associated employees, prevent deletion and throw an exception
            throw new DeletionException("Role cannot be deleted as it is associated with one or more employees.");
        }
    }
}
